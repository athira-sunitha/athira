package com.Athira.kelexam.generator.controller;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;


public class Componentfinder {
	private Container container=null;
	private ArrayList<Component> allComponents=new ArrayList<Component>();
	public Componentfinder(Container container) {
		super();
		this.container = container;
		}
	
	public Componentfinder() {
	}

	private void getAllComponents(Container childContainer) {
		Component components[]=childContainer.getComponents();

		for(Component component:components)
		{ 
			if(component instanceof JPanel ||
					component instanceof JScrollPane ||
					component instanceof JTabbedPane ||
					component instanceof JDialog ||
					component instanceof JFrame){
				allComponents.add(component);
				getAllComponents((Container)component);
			}
			else {
				
					allComponents.add(component);
					
				}
			}
	}
		
	public Component findComponent(String name) {
		getAllComponents(container);
		for (Component item:allComponents) {
			
			if(item.getName().equals(name)) {
				return item;
			}
		}
		return null;
	}
	 public String getSelectedButtonText(ButtonGroup buttonGroup) {
	        for (java.util.Enumeration<javax.swing.AbstractButton> buttons = buttonGroup
	        		.getElements(); buttons.hasMoreElements();) {
	            javax.swing.AbstractButton button = buttons.nextElement();

	            if (button.isSelected()) {
	                return button.getText();
	            }
	        }

	        return "";
	    }

}
