package com.example.OscarSite.repository;


import java.util.ArrayList;
import com.example.OscarSite.model.Oscar;
public interface OscarRepository{
    ArrayList<Oscar> getALLDetails();

    ArrayList<Oscar> getstatusDetailsSpecificYear(String statusDetail,int wantedyear);

    ArrayList<Oscar> getCategoryDetailsSpecificYear(String CategoryDetail,String statusDetail,int wantedyear);


    ArrayList<Oscar> getCategoryDetails(String CategoryDetail,int yearInfo);




    Oscar getDetailsById(int rowId);

    Oscar AddDetails(Oscar NewOscarInfo);

   Oscar updateRowOscar(int rowId, Oscar Updateinfo);

    void deleteInfo(int rowid);
    
}
























