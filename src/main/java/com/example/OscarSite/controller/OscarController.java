
package com.example.OscarSite.controller;

import com.example.OscarSite.model.Oscar;
import com.example.OscarSite.service.OscarH2Service;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class OscarController{
    //OscarService oscarService=new OscarService();

    @Autowired
    public OscarH2Service oscarService;
    

    @GetMapping("/Oscar")
    public ArrayList<Oscar> getDetails(){
        return oscarService.getALLDetails();
    }

    @GetMapping("/{statusinfo}/{yearId}")

    public ArrayList<Oscar> getStatusDetails(@PathVariable("statusinfo") String status1, @PathVariable("yearId") int year){
        return oscarService.getstatusDetailsSpecificYear(status1,year);
    }

    @GetMapping("/shortlisted/{CategoryInfo}/{yearId}")

    public ArrayList<Oscar> getCategoryDetails(@PathVariable("CategoryInfo") String Category1, @PathVariable("yearId") int year){
        return oscarService.getCategoryDetails(Category1,year);
    }

    @GetMapping("/{categoryinformation}/{statusinformation}/{yearId}")

    public ArrayList<Oscar> getStatusDetails(@PathVariable("categoryinformation") String categoryDetail1,@PathVariable("statusinformation") String status1, @PathVariable("yearId") int year){
        return oscarService.getCategoryDetailsSpecificYear(categoryDetail1,status1,year);
    }

   @GetMapping("/Oscar/{rowId1}")
    public Oscar specificROw(@PathVariable("rowId1") int id){
        return oscarService.getDetailsById(id);
    }
    

    @PostMapping("/add")
    public Oscar addingNewRow(@RequestBody Oscar NewoscarDetails ){
        return oscarService.AddDetails(NewoscarDetails);

    }
    
    @PutMapping("/update/{id}")
    public Oscar updateRow(@PathVariable("id") int rowid,@RequestBody Oscar NtUpdateInfo){
        return oscarService.updateRowOscar(rowid, NtUpdateInfo);

    }

    @DeleteMapping("/delete/{rowId}")
    public void deleteBook(@PathVariable("rowId") int Id) {
        oscarService.deleteInfo(Id);
    }
}






