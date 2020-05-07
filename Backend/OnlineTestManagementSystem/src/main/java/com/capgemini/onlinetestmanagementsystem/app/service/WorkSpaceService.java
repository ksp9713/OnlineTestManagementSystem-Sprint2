package com.capgemini.onlinetestmanagementsystem.app.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.onlinetestmanagementsystem.app.dao.WorkSpaceDaoInterface;
import com.capgemini.onlinetestmanagementsystem.app.entity.WorkSpaceData;
import com.capgemini.onlinetestmanagementsystem.app.exception.WorkSpaceException;

@Service
public class WorkSpaceService implements WorkSpaceServiceInterface{
	
	@Autowired
	WorkSpaceDaoInterface workspaceDaoInterfaceReferenceObject;

	@Override
	public WorkSpaceData addEntry(WorkSpaceData entry) throws WorkSpaceException {
		return workspaceDaoInterfaceReferenceObject.addEntry(entry) ;
	}

	@Override
	public List<WorkSpaceData> retrieveAllEntries() {
		return workspaceDaoInterfaceReferenceObject.retrieveAllEntries();
	}

	@Override
	public Boolean deleteEntry(Long sequence)throws WorkSpaceException {
		return workspaceDaoInterfaceReferenceObject.deleteEntry(sequence);
	}

	@Override
	public Boolean updateEntry(WorkSpaceData entryUpdate) throws WorkSpaceException {
		return workspaceDaoInterfaceReferenceObject.updateEntry(entryUpdate);
	}
}
