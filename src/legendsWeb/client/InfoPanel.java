package legendsWeb.client;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class InfoPanel {
	private TextBox nameField = new TextBox();
	private TextBox clanField = new TextBox();
	private TextBox schoolField = new TextBox();
	private TextBox rankField = new TextBox();
	private TextBox insightField = new TextBox();
	private FlexTable infoTable = new FlexTable();
	private VerticalPanel infoPanel = new VerticalPanel();
	private RPGCharacter rpgChar;

	public TextBox getNameField() {
		return nameField;
	}
	
	public Panel createInfoPanel(RPGCharacter rpgChar) {
		this.rpgChar = rpgChar;

		infoTable.setText(0, 0, "Name");
		infoTable.setWidget(0, 1, nameField);
		nameField.addKeyUpHandler(infoUpdater);
		nameField.addStyleName("NameBox");
		nameField.setFocus(true);

		infoTable.setText(0, 2, "Clan");
		infoTable.setWidget(0, 3, clanField);
		clanField.addKeyUpHandler(infoUpdater);
		clanField.addStyleName("ClanBox");

		infoTable.setText(0, 4, "School");
		infoTable.setWidget(0, 5, schoolField);
		schoolField.addKeyUpHandler(infoUpdater);
		schoolField.addStyleName("SchoolBox");

		infoTable.setText(0, 6, "Rank");
		infoTable.setWidget(0, 7, rankField);
		rankField.addKeyUpHandler(infoUpdater);
		rankField.addStyleName("RankBox");

		infoTable.setText(0, 8, "Insight");
		infoTable.setWidget(0, 9, insightField);
		insightField.addKeyUpHandler(infoUpdater);
		insightField.addStyleName("InsightBox");

		infoPanel.add(infoTable);
		return infoPanel;
	}

	private KeyUpHandler infoUpdater = new KeyUpHandler() {

		@Override
		public void onKeyUp(KeyUpEvent event) {
			updateCharacterInfo();
		}

	};

	private void updateCharacterInfo() {
		rpgChar.setName(nameField.getText());
		rpgChar.setClan(clanField.getText());
		rpgChar.setSchool(schoolField.getText());
	}
}
