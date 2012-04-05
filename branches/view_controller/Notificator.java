package view_controller;

import java.awt.Frame;

import javax.swing.JOptionPane;

public class Notificator {
	 
	Frame frame;
	
	public Notificator(Frame frame){
		this.frame = frame;
	}
	
	public void sendMessage(String msg,String title){
		JOptionPane.showMessageDialog(frame,msg,title,JOptionPane.INFORMATION_MESSAGE);	
		}
	
	public void sendAlert(String msg,String title){
		JOptionPane.showMessageDialog(frame,msg,title,JOptionPane.WARNING_MESSAGE);	
		}
	
	public void sendError(String msg,String title){
		JOptionPane.showMessageDialog(frame,msg,title,JOptionPane.ERROR_MESSAGE);	
		}
	
	public void sendQuestion(String msg,String title){
		JOptionPane.showMessageDialog(frame,msg,title,JOptionPane.OK_OPTION);	
		
		}
}
