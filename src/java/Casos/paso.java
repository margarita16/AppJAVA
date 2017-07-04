/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casos;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/*
 * @author asus
 */
@ServerEndpoint("/paso")
public class paso {
 
    @OnOpen
    public void onOpen(Session session){
        System.out.println(session.getId() + "ha ingresado");
        try { 
            session.getBasicRemote().sendText("conexion establecida");
            
    } catch (IOException ex){
        ex.printStackTrace();
    }
    
    }
         @OnMessage
public void onMessage(String message, Session session){
    System.out.println("Mensaje"+ session.getId()+ ":" + message);
    try{
        session.getBasicRemote().sendText(message);
        } catch (IOException ex) {
          ex.printStackTrace();
        }
 }

  @OnClose
  
  public void onClose(Session session){
      System.out.println("Sesion"+session.getId()+" ha terminado");
      
  }
  
 }
