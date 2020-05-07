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
		return workspaceDaoInterfaceReferenceObject.addEntry(entry) ;
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
		return workspaceDaoInterfaceReferenceObject.retrieveAllEntries();
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
	public Boolean deleteEntry(Long sequence)throws WorkSpaceException {
		return workspaceDaoInterfaceReferenceObject.deleteEntry(sequence);
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
	public WorkSpaceData updateEntry(Long sequenceId , WorkSpaceData entryUpdate) throws WorkSpaceException {
		return workspaceDaoInterfaceReferenceObject.updateEntry(sequenceId,entryUpdate);
	}
}
