package com.capgemini.onlinetestmanagementsystem.app.service;
import java.util.List;
import com.capgemini.onlinetestmanagementsystem.app.entity.WorkSpaceData;
import com.capgemini.onlinetestmanagementsystem.app.exception.WorkSpaceException;

public interface WorkSpaceServiceInterface{
	
	public WorkSpaceData addEntry(WorkSpaceData entry) throws WorkSpaceException;
	
	public List<WorkSpaceData> retrieveAllEntries();
	
	public Boolean deleteEntry(Long sequence)throws WorkSpaceException;
	
	public Boolean updateEntry(WorkSpaceData entryUpdate)throws WorkSpaceException;
}
