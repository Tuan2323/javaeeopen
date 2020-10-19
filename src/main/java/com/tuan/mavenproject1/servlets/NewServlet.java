/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuan.mavenproject1.servlets;

import com.tuan.mavenproject1.beans.Auteur;
import com.tuan.mavenproject1.forms.ConnectionForm;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


/**
 *
 * @author Tuan
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class NewServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
    public static final int TAILLE_TAMPON = 10240;
    public static final String CHEMIN_FICHIERS = "/Users/Tuan/fichiers/"; // A changer

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    /*    String message = "au revoir";
        request.setAttribute("variable", message);
         request.setAttribute("heure", "soir");
         String name = request.getParameter("name");
         request.setAttribute("name", name);
         String[] noms = {"ok","po","io"};
         request.setAttribute("noms", noms); // envoie OBJ*/
         Auteur auteur = new Auteur();
         auteur.setPrenom("Tuan");
         auteur.setNom("Tran");
         auteur.setActif(true);
         request.setAttribute("auteur", auteur);
         
          HttpSession session = request.getSession();
          String prenom = (String) session.getAttribute("prenom");
         session.invalidate(); // coupe la session
         request.getRequestDispatcher("WEB-INF/bonjour.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     /*   ConnectionForm form = new ConnectionForm();
        form.verifierIdentifiants(request);
        request.setAttribute("form", form);*/
       /* String nom = request.getParameter("nom");
        request.setAttribute("nom", nom);
        
        request.getRequestDispatcher("WEB-INF/bonjour.jsp").forward(request, response);
        */
        // On récupère le champ description comme d'habitude
      /*  String description = request.getParameter("description");
        request.setAttribute("description", description );

        // On récupère le champ du fichier
        Part part = request.getPart("fichier");
            
        // On vérifie qu'on a bien reçu un fichier
        String nomFichier = getNomFichier(part);

        // Si on a bien un fichier
        if (nomFichier != null && !nomFichier.isEmpty()) {
            String nomChamp = part.getName();
            // Corrige un bug du fonctionnement d'Internet Explorer
             nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
                    .substring(nomFichier.lastIndexOf('\\') + 1);

            // On écrit définitivement le fichier sur le disque
            ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);

            request.setAttribute(nomChamp, nomFichier);
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
        */
      
          String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        
        HttpSession session = request.getSession();

        session.setAttribute("nom", nom);
        session.setAttribute("prenom", prenom);
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
    }
      
      
    
      
    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        } finally {
            try {
                sortie.close();
            } catch (IOException ignore) {
            }
            try {
                entree.close();
            } catch (IOException ignore) {
            }
        }
    }
    
    private static String getNomFichier( Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    }   
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
