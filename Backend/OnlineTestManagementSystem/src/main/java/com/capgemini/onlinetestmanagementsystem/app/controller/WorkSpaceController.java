package com.capgemini.onlinetestmanagementsystem.app.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.onlinetestmanagementsystem.app.entity.WorkSpaceData;
import com.capgemini.onlinetestmanagementsystem.app.exception.WorkSpaceException;
import com.capgemini.onlinetestmanagementsystem.app.service.WorkSpaceServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/entries")
public class WorkSpaceController{
		
	@Autowired
	WorkSpaceServiceInterface workspaceServiceInterface;
	
	@PostMapping("/add")
	public ResponseEntity<WorkSpaceData> addEntry(@RequestBody WorkSpaceData entry) throws WorkSpaceException{	
		try {
			WorkSpaceData response = workspaceServiceInterface.addEntry(entry);
			System.out.println("Entry Added Successfully : "+ response);
			return new ResponseEntity<WorkSpaceData>(response,HttpStatus.OK);
		}
		catch(WorkSpaceException exp){
			System.out.println("Entry Not Added");
			return new ResponseEntity<WorkSpaceData>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/getAllEntries")
    public ResponseEntity<List<WorkSpaceData>> getAllEntries(){
			List<WorkSpaceData> entryList = workspaceServiceInterface.retrieveAllEntries();
			return new ResponseEntity<List<WorkSpaceData>>(entryList,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEntry/{sequenceId}")
	public ResponseEntity<WorkSpaceData> deleteEntry(@PathVariable("sequenceId") Long sequenceId) throws WorkSpaceException{
		if(workspaceServiceInterface.deleteEntry(sequenceId)){
			return new ResponseEntity<WorkSpaceData>(HttpStatus.OK);
		}
		return new ResponseEntity<WorkSpaceData>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateEntry/{sequenceId}")
	public ResponseEntity<WorkSpaceData> updateEntry(@RequestBody WorkSpaceData entry) throws WorkSpaceException {
		try {
			Boolean response = workspaceServiceInterface.updateEntry(entry);
			System.out.println("Entry Updated Successfully : "+ response);
			return new ResponseEntity<WorkSpaceData>(entry,HttpStatus.OK);
		}
		catch(WorkSpaceException exp){
			return new ResponseEntity<WorkSpaceData>(HttpStatus.NOT_FOUND);
		}
	}
}
