package legendsWeb.client;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class WoundsPanel implements IListener {
	private Panel woundsPanel = new VerticalPanel();
	private FlexTable wTable = new FlexTable();
	private ArrayList<Integer> woundsLevel = new ArrayList<Integer>();
	private RPGCharacter rpgChar;
	private TextBox currentWoundsBox = new TextBox();

	public Panel createWoundsPanel(RPGCharacter rpgChar) {
		this.rpgChar = rpgChar;
		populateWounds();
		// TODO create wounds table
		wTable.setText(0, 0, "Wounds");
		wTable.getFlexCellFormatter().setColSpan(0, 0, 2);
		wTable.getCellFormatter().setHorizontalAlignment(0, 0,
				HasHorizontalAlignment.ALIGN_CENTER);
		wTable.getRowFormatter().addStyleName(1, "WoundsTitle");

		wTable.setStyleName("WoundsLevels");
		wTable.setText(1, 0, "Wound\nLevel");
		wTable.setText(1, 1, "Total");
		wTable.setText(2, 0, "Healthy (+0)");
		wTable.setText(3, 0, "Nicked (+3)");
		wTable.setText(4, 0, "Grazed (+5)");
		wTable.setText(5, 0, "Hurt (+10)");
		wTable.setText(6, 0, "Injured (+15)");
		wTable.setText(7, 0, "Crippled (+20)");
		wTable.setText(8, 0, "Down (+40)");
		wTable.setText(9, 0, "Out");

		wTable.setText(10, 0, "Current");
		wTable.setWidget(10, 1, currentWoundsBox);
		currentWoundsBox.setText("0");
		currentWoundsBox.addKeyUpHandler(woundChecker);

		createWoundLevels();

		woundsPanel.add(wTable);
		return woundsPanel;

	}

	private void createWoundLevels() {
		for (int i = 0; i < woundsLevel.size(); i++) {
			// TODO check if woundlvl is <= currentDmg, if true, apply
			// "woundLevelPassed" style
			Label woundWidget = new Label();
			woundWidget.setText(woundsLevel.get(i) + "");
			if (checkIfWoundLevelExpired(Integer
					.parseInt(woundWidget.getText()))) {
				woundWidget.setStyleName("woundLevelPassed");
			}
			wTable.setWidget(i + 2, 1, woundWidget);
		}
	}

	// TODO populate list of wounds and its levels
	public void populateWounds() {
		woundsLevel.clear();
		woundsLevel.add(rpgChar.getEarthRing() * 2);
		woundsLevel.add(rpgChar.getEarthRing() * 4);
		woundsLevel.add(rpgChar.getEarthRing() * 6);
		woundsLevel.add(rpgChar.getEarthRing() * 8);
		woundsLevel.add(rpgChar.getEarthRing() * 10);
		woundsLevel.add(rpgChar.getEarthRing() * 12);
		woundsLevel.add(rpgChar.getEarthRing() * 14);
		woundsLevel.add(rpgChar.getEarthRing() * 19);

	}

	@Override
	public void dataUpdated() {
		populateWounds();
		System.out.println(woundsLevel);
		createWoundLevels();

	}

	@Override
	public void loadNewCharacter() {
		// TODO Auto-generated method stub

	}

	KeyUpHandler woundChecker = new KeyUpHandler() {

		@Override
		public void onKeyUp(KeyUpEvent event) {
			createWoundLevels();
		}
	};

	private boolean checkIfWoundLevelExpired(int woundLevel) {
		int damage = Integer.parseInt(currentWoundsBox.getText());

		if (damage > woundLevel) {
			return true;
		} else {
			return false;
		}

	}

}
