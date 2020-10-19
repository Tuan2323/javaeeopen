/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuan.mavenproject1.forms;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Tuan
 */
public class ConnectionForm {
    private String resultat;
    
    public void verifierIdentifiants( HttpServletRequest request){
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        if(pass.equals(login+ "123")){
            resultat = "Vous etes bien connecte";
            
        }
        else {
            resultat ="pas ci";
        }
    }
    public String getResultat(){
        return resultat;
    }
    
    public void setResultat(String resultat) {
    this.resultat = resultat;
    
}
}
