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
	
	/************************************************************************************
	 * Method: addEntry
     * Description: All the Assign Test to User with details is stored here.
	 * @param entry                   - WorkSpaceData Object Containing Test Details assigned to User with userID.
	 * @returns entry                 - WorkSpaceData Object, if entry added otherwise throws WorkSpaceException
	 * @throws WorkSpaceException     - It is raised entry not added somehow. 
     * Created By                     - Suraj Pakhare
     * Created Date                   - 23-APR-2020                           
	 ************************************************************************************/

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
	
	/************************************************************************************
	 * Method: retrieveAllEntries
     * Description: Method to retrieve all the stored entries
	 * @param void                    - void
	 * @returns List<WorkSpaceData>   - List of all the entries Stored.
     * Created By                     - Suraj Pakhare
     * Created Date                   - 23-APR-2020                           
	 ************************************************************************************/


	@Override
	public List<WorkSpaceData> retrieveAllEntries() {
		String queryString = "SELECT entries FROM WorkSpaceData entries";
		TypedQuery<WorkSpaceData> query = myManager.createQuery(queryString , WorkSpaceData.class);
		return query.getResultList();
	}

	/************************************************************************************
	 * Method: deleteEntry
     * Description: Method to remove a stored entry.
	 * @param sequenceId              - entry number
	 * @returns Boolean               - returns true if entry deleted otherwise false.
	 * @throws WorkSpaceException     - If entry not found
     * Created By                     - Suraj Pakhare
     * Created Date                   - 23-APR-2020                           
	 ************************************************************************************/

	
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

	/************************************************************************************
	 * Method: updateEntry
     * Description: Method to update a stored entry.
	 * @param sequenceId              - entry number
	 * @returns entryObject           - Object containing all the modified data.
	 * @throws WorkSpaceException     - If entry not found
     * Created By                     - Suraj Pakhare
     * Created Date                   - 23-APR-2020                           
	 ************************************************************************************/
	@Override
	public WorkSpaceData updateEntry(Long sequenceId,WorkSpaceData entryUpdate) throws WorkSpaceException {
		
		WorkSpaceData checkEntry;
		System.out.println("Dao Called");
		
		checkEntry = myManager.find(WorkSpaceData.class , sequenceId);
		
		if(checkEntry == null)
			throw new WorkSpaceException("Entry Not Found");
		else {
			System.out.println("Updating in Process");
			checkEntry.setMarksScored(entryUpdate.getMarksScored());
			checkEntry.setTestStatus(entryUpdate.getTestStatus());
			checkEntry.setUserFeedback(entryUpdate.getUserFeedback());
			checkEntry.setTestTitle(entryUpdate.getTestTitle());
		}
		return checkEntry;
	}
}
