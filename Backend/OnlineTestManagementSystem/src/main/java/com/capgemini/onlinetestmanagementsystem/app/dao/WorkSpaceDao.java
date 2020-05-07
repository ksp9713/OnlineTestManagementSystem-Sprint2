package com.capgemini.onlinetestmanagementsystem.app.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.capgemini.onlinetestmanagementsystem.app.entity.WorkSpaceData;
import com.capgemini.onlinetestmanagementsystem.app.exception.WorkSpaceException;

@Transactional 
@Repository
public class WorkSpaceDao implements WorkSpaceDaoInterface{
	
	@PersistenceContext
	EntityManager myManager;

	@Override
	public WorkSpaceData addEntry(WorkSpaceData entry) throws WorkSpaceException {
		if(entry == null)
			throw new WorkSpaceException("Entry Not Added");
		
		myManager.persist(entry);
		
		WorkSpaceData checkEntry = myManager.find(WorkSpaceData.class , entry.getSequence());
		
		if(checkEntry == null)
			throw new WorkSpaceException("Entry Not Added");
		
		System.out.println("Test Assigned Successfully");
		
		return checkEntry;
	}

	@Override
	public List<WorkSpaceData> retrieveAllEntries() {
		String queryString = "SELECT entries FROM WorkSpaceData entries";
		TypedQuery<WorkSpaceData> query = myManager.createQuery(queryString , WorkSpaceData.class);
		return query.getResultList();
	}

	@Override
	public Boolean deleteEntry(Long sequence) throws WorkSpaceException {
		Boolean test = false;
		WorkSpaceData checkEntry = myManager.find(WorkSpaceData.class , sequence);
		if(checkEntry == null)
			throw new WorkSpaceException("Entry Not Found");
		else {
			test = true;
			myManager.remove(checkEntry);
			System.out.println(sequence +" Entry" + " deleted");
		}
		return test;
	}

	@Override
	public Boolean updateEntry(WorkSpaceData entryUpdate) throws WorkSpaceException {
		Boolean test = false;
		WorkSpaceData checkEntry = myManager.find(WorkSpaceData.class , entryUpdate.getSequence());
		if(checkEntry == null)
			throw new WorkSpaceException("Entry Not Found");
		else {
			test = true;
			checkEntry.setMarksScored(entryUpdate.getMarksScored());
			
			if(checkEntry.getTestStatus() == 0 || checkEntry.getTestStatus() == -1) {
				checkEntry.setTestId(entryUpdate.getTestId());
				checkEntry.setTestStatus(0);
			}
			else {
				test = false;
				throw new WorkSpaceException("Test Already Attempted By User");
			}
			
			if(checkEntry.getTestStatus() == 0 || checkEntry.getTestStatus() == -1) {
				checkEntry.setUserId(entryUpdate.getUserId());
				checkEntry.setTestStatus(0);
			}
			else {
				test = false;
				throw new WorkSpaceException("Test Already Attempted By User");
			}
			
			checkEntry.setTestStatus(entryUpdate.getTestStatus());
			
			checkEntry.setTestDuration(entryUpdate.getTestDuration());
			
			checkEntry.setUserFeedback(entryUpdate.getUserFeedback());
		}
		return test;
	}
}
