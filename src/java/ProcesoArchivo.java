/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Servlet implementation class ProcesoArchivo
 */
@WebServlet("/ProcesoArchivo")
@MultipartConfig
public class ProcesoArchivo extends HttpServlet { 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          
    
    private static final long serialVersionUID = 1L;
       
        
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesoArchivo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu 
		try {  
		Part arch = request.getPart("archivo");
		InputStream is = arch.getInputStream();
    // Crear un objeto DocumentBuilderFactory y DocumentBuilder
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(); 
    // Analizar el InputStream y crear un objeto Document
    Document doc = dBuilder.parse(is); 
    // Opcional: normalizar el árbol DOM
    doc.getDocumentElement().normalize(); 
    // Obtener una lista de nodos con la etiqueta deseada
    NodeList nombre = doc.getElementsByTagName("valida"); 
    NodeList desarrollador = doc.getElementsByTagName("mensaje");  
    // Enviar una respuesta al cliente
         response.setContentType("text/html"); 
            response.getWriter().println("<html><body><style>p1{color:white}</style><p1>Etiqueta Raiz: </p1></body></html>: <strong>"+doc.getDocumentElement().getNodeName()+"</strong>");
            NodeList nodeList = doc.getElementsByTagName("*");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    response.getWriter().println("<html><body><style>p1{color:white}</style><p1>Etiqueta: </p1></body></html>" + node.getNodeName());
                }
            }
   
    for (int i = 0; i < nombre.getLength(); i++) {
      Node node = nombre.item(i);  
      Node node_desarrollador = desarrollador.item(i);  
      response.getWriter().println("<html><body><style>p1{color:white}</style><p1>Nombre: </p1></body></html>");  
      response.getWriter().println(node.getTextContent()); 
      response.getWriter().println("<html><body><style>p1{color:white}</style><p1>Desarrollador: </p1></body></html>"); 
      response.getWriter().println(node_desarrollador.getTextContent());
      response.getWriter().println("<br>"); 
    }  
    response.getWriter().println("<html><body><style>h1{color:white}</style><h1>Archivo XML procesado con éxito</h1></body></html>");
    } catch (Exception e) {
      e.printStackTrace();
      response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar el archivo XML");
    }
                
}
        
}}
