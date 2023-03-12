package com.example.OscarSite.service;
import java.util.*;


import org.springframework.jdbc.core.JdbcTemplate;

import com.example.OscarSite.model.Oscar;
import com.example.OscarSite.model.OscarRowMapper;
import com.example.OscarSite.repository.OscarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OscarH2Service implements OscarRepository{
    @Autowired
    private JdbcTemplate db;
	

    public ArrayList<Oscar> getALLDetails(){
        List<Oscar> oscarList=db.query("select * from oscar",new OscarRowMapper());
        ArrayList<Oscar> OscarAllRows=new ArrayList<>(oscarList);
        return OscarAllRows;
    }

    @Override
    public ArrayList<Oscar> getstatusDetailsSpecificYear(String statusDetail,int wantedyear){
        
		List<Oscar> oscarList=db.query("select * from oscar where status=? and yearof=?",new OscarRowMapper(),statusDetail,wantedyear);
        ArrayList<Oscar> OscarAllRows=new ArrayList<>(oscarList);
        return OscarAllRows;

    }



    @Override
    public ArrayList<Oscar> getCategoryDetailsSpecificYear(String CategoryDetail,String statusDetail,int wantedyear){
        List<Oscar> oscarList=db.query("select * from oscar where (category=? and status=?) and yearof=?",new OscarRowMapper(),CategoryDetail,statusDetail,wantedyear);
        ArrayList<Oscar> OscarAllRows=new ArrayList<>(oscarList);
        return OscarAllRows;

    }

    @Override
    public Oscar getDetailsById(int rowId){
        try{
            Oscar oscarObj=db.queryForObject("select * from Oscar where id=?",new OscarRowMapper(),rowId);
            return oscarObj;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
    }

    @Override
    public Oscar AddDetails(Oscar NewOscarInfo){

        db.update("insert into oscar(name,category,status,yearof) values (?,?,?,?)",NewOscarInfo.getName(),NewOscarInfo.getCategory(),NewOscarInfo.getStatus(),NewOscarInfo.getYearOf());

        Oscar SavedOsacrDetails=db.queryForObject("select * from oscar where name=? and category=?", new OscarRowMapper(),NewOscarInfo.getName(),NewOscarInfo.getCategory());
        return SavedOsacrDetails;
    }

	@Override
	public Oscar updateRowOscar(int rowId, Oscar Updateinfo) {
		if(Updateinfo.getStatus() != null){
            db.update("update oscar set status=? where id=?",Updateinfo.getStatus(),rowId);
        }
		return getDetailsById(rowId);
	}

	@Override
	public void deleteInfo(int rowid) {
		db.update("delete from oscar where id=?",rowid);
		
	}

	@Override
	public ArrayList<Oscar> getCategoryDetails(String CategoryDetail, int yearInfo) {
        List<Oscar> oscarList=db.query("select * from oscar where category=? and yearof=?",new OscarRowMapper(),CategoryDetail,yearInfo);
        ArrayList<Oscar> OscarAllRows=new ArrayList<>(oscarList);
        return OscarAllRows;

	}



}