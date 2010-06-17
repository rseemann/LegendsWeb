package legendsWeb.client;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.*;

public class SkillPanel {
	private FlexTable skillFlexTable = new FlexTable();
	private RPGCharacter rpgChar;

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
