package legendsWeb.client;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

public class SkillPanel {
	private FlexTable skillPanel = new FlexTable();
	private FlexTable skillsFlexTable = new FlexTable();
	private RPGCharacter rpgChar;
	private DialogBox newSkillDialog = new DialogBox();
	
	public Button newSkillButton() {
		Button addSkillButton = new Button("Add Skill");
		newSkillDialog.setAnimationEnabled(true);
		newSkillDialog.setGlassEnabled(true);
		
		
		addSkillButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				createPopupToNewSkill();
				newSkillDialog.center();
				newSkillDialog.setText("Insert new skill's name and rank");
				newSkillDialog.show();
			}
		});
		return addSkillButton;

	}

	public Panel createSkillPanel(RPGCharacter rpgChar) {
		this.rpgChar = rpgChar;
		
		skillPanel.setWidget(0, 1, newSkillButton());
		skillPanel.setWidget(0, 0, skillsFlexTable);
		return skillPanel;

	}

	public void createPopupToNewSkill() {
		final FlexTable newSkillPopup = new FlexTable();
		final TextBox skillName = new TextBox();
		skillName.addStyleName("NameBox");
		skillName.setFocus(true);	
		
		final TextBox skillRank = new TextBox();
		skillRank.addStyleName("RankBox");
		Button saveSkill = new Button("Save");
		
		saveSkill.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String newSkillName = skillName.getText();
				int newSkillRank = (Integer.parseInt(skillRank.getText()));
				
				rpgChar.addSkill(newSkillName, newSkillRank);
				addSkillToPanel(rpgChar.getSkills());
				newSkillDialog.hide();

			}
		});

		Button cancelSkill = new Button("Cancel");

		cancelSkill.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				newSkillDialog.hide();

			}
		});

		newSkillPopup.setText(0, 0, "Name");
		newSkillPopup.setWidget(1, 0, skillName);
		newSkillPopup.setText(0, 1, "Rank");
		newSkillPopup.setWidget(1, 1, skillRank);
		newSkillPopup.setWidget(1, 2, saveSkill);
		newSkillPopup.getFlexCellFormatter().setRowSpan(1, 2, 3);
		newSkillPopup.setWidget(1, 3, cancelSkill);
		newSkillPopup.getFlexCellFormatter().setRowSpan(1, 3, 3);
		newSkillDialog.setWidget(newSkillPopup);

	}
	
	

	public void addSkillToPanel(ArrayList<Skill> skills) {
		skillsFlexTable.clear();
		for (Skill skill : skills) {
			System.out.println(skill.getName());
			
			Hyperlink skillLink = new Hyperlink(skill.getName(), "");
			
			int row = skillsFlexTable.getRowCount();
			skillsFlexTable.setWidget(row, 0, skillLink);
			
		}
			
	}

}
