package legendsWeb.client;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

public class SkillPanel {
	private FlexTable skillFlexTable = new FlexTable();
	private RPGCharacter rpgChar;
	
	public Button newSkillButton(){
		Button addSkillButton = new Button("Add Skill");
		addSkillButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.confirm("uhul!");
				
			}
		});
		return addSkillButton;
		
	}
	
	public Panel CreateSkillPanel(RPGCharacter rpgChar) {
		this.rpgChar = rpgChar;
		addSkillToPanel(rpgChar.getSkills());

		return null;

	}

	public void addSkillToPanel(ArrayList<Skill> skills) {
		for (Skill skill : skills) {
			
			PopupPanel skillLink = new PopupPanel();
			skillLink.setWidget(new Label("testing popup"));
			
			int row = skillFlexTable.getRowCount();
			
			skillFlexTable.setWidget(row, 0, skillLink);
		}
	}
}
