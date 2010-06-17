package legendsWeb.client;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TopPanel implements IListener{
	private VerticalPanel topPanel = new VerticalPanel();
	private FlexTable earthPanel = new FlexTable();
	private FlexTable waterPanel = new FlexTable();
	private FlexTable firePanel = new FlexTable();
	private FlexTable airPanel = new FlexTable();
	private FlexTable voidPanel = new FlexTable();
	private FlexTable ringsAndTraitsTable = new FlexTable();
	private TextBox earthRank = new TextBox();
	private TextBox stamRank = new TextBox();
	private TextBox willRank = new TextBox();
	private TextBox waterRank = new TextBox();
	private TextBox streRank = new TextBox();
	private TextBox percRank = new TextBox();
	private TextBox fireRank = new TextBox();
	private TextBox agilRank = new TextBox();
	private TextBox inteRank = new TextBox();
	private TextBox airRank = new TextBox();
	private TextBox reflRank = new TextBox();
	private TextBox awarRank = new TextBox();
	private TextBox voidRank = new TextBox();
	private TextBox spentRank = new TextBox();
	private RPGCharacter rpgChar;

	public VerticalPanel createTopPanel(RPGCharacter rpgChar) {
		this.rpgChar = rpgChar;
	


		// ---------------rings and traits parts-------------------------
		ringsAndTraitsTable.setHTML(0, 0,
				"<img src=images/rings/RingofEarth.jpg>");
		ringsAndTraitsTable.setHTML(0, 1,
				"<img src=images/rings/RingofWater.jpg>");
		ringsAndTraitsTable.setHTML(0, 2,
				"<img src=images/rings/RingofFire.jpg>");
		ringsAndTraitsTable.setHTML(0, 3,
				"<img src=images/rings/RingofAir.jpg>");
		ringsAndTraitsTable.setHTML(0, 4,
				"<img src=images/rings/RingofVoid.jpg>");

		// TODO add traits and its ranks

		// earth ring
		earthPanel.setText(0, 0, "Earth");
		earthPanel.setWidget(0, 1, earthRank);
		earthRank.setEnabled(false);

		earthPanel.setText(1, 0, "Stamina");
		earthPanel.setWidget(1, 1, stamRank);
		stamRank.setText("2");
		stamRank.addKeyUpHandler(traitUpdater);

		earthPanel.setText(2, 0, "Willpower");
		earthPanel.setWidget(2, 1, willRank);
		willRank.addKeyUpHandler(traitUpdater);
		willRank.setText("5");

		// water ring
		waterPanel.setText(0, 0, "Water");
		waterPanel.setWidget(0, 1, waterRank);
		waterRank.setEnabled(false);

		waterPanel.setText(1, 0, "Strength");
		waterPanel.setWidget(1, 1, streRank);
		streRank.addKeyUpHandler(traitUpdater);
		streRank.setText("0");

		waterPanel.setText(2, 0, "Perception");
		waterPanel.setWidget(2, 1, percRank);
		percRank.addKeyUpHandler(traitUpdater);
		percRank.setText("0");

		// fire ring
		firePanel.setText(0, 0, "Fire");
		firePanel.setWidget(0, 1, fireRank);
		fireRank.setEnabled(false);

		firePanel.setText(1, 0, "Agility");
		firePanel.setWidget(1, 1, agilRank);
		agilRank.addKeyUpHandler(traitUpdater);
		agilRank.setText("0");

		firePanel.setText(2, 0, "Intelligence");
		firePanel.setWidget(2, 1, inteRank);
		inteRank.addKeyUpHandler(traitUpdater);
		inteRank.setText("0");

		// air ring
		airPanel.setText(0, 0, "Air");
		airPanel.setWidget(0, 1, airRank);
		airRank.setEnabled(false);

		airPanel.setText(1, 0, "Reflexes");
		airPanel.setWidget(1, 1, reflRank);
		reflRank.addKeyUpHandler(traitUpdater);
		reflRank.setText("0");
		airPanel.setText(2, 0, "Awareness");
		airPanel.setWidget(2, 1, awarRank);
		awarRank.addKeyUpHandler(traitUpdater);
		awarRank.setText("0");

		// void ring
		voidPanel.setText(0, 0, "Void");
		voidPanel.setWidget(0, 1, voidRank);
		voidRank.addKeyUpHandler(traitUpdater);
		voidRank.setText("0");

		voidPanel.setText(1, 0, "Void Spent");
		voidPanel.setWidget(1, 1, spentRank);

		updateRingsBox();

		// add to panel
		ringsAndTraitsTable.setBorderWidth(5);
		ringsAndTraitsTable.setWidget(1, 0, earthPanel);
		ringsAndTraitsTable.getCellFormatter().setHorizontalAlignment(1, 0,
				HasHorizontalAlignment.ALIGN_CENTER);
		ringsAndTraitsTable.setWidget(1, 1, waterPanel);
		ringsAndTraitsTable.getCellFormatter().setHorizontalAlignment(1, 1,
				HasHorizontalAlignment.ALIGN_CENTER);
		ringsAndTraitsTable.setWidget(1, 2, firePanel);
		ringsAndTraitsTable.getCellFormatter().setHorizontalAlignment(1, 2,
				HasHorizontalAlignment.ALIGN_CENTER);
		ringsAndTraitsTable.setWidget(1, 3, airPanel);
		ringsAndTraitsTable.getCellFormatter().setHorizontalAlignment(1, 3,
				HasHorizontalAlignment.ALIGN_CENTER);
		ringsAndTraitsTable.setWidget(1, 4, voidPanel);
		ringsAndTraitsTable.getCellFormatter().setHorizontalAlignment(1, 4,
				HasHorizontalAlignment.ALIGN_CENTER);

		
		topPanel.add(ringsAndTraitsTable);
		return topPanel;
	}

	private KeyUpHandler traitUpdater = new KeyUpHandler() {

		@Override
		public void onKeyUp(KeyUpEvent event) {
			updateCharacter();

		}
	};

	public void updateCharacter() {
		rpgChar.setStamina(Integer.parseInt(stamRank.getText()));
		rpgChar.setWillpower(Integer.parseInt(willRank.getText()));
		rpgChar.setStrength(Integer.parseInt(streRank.getText()));
		rpgChar.setPerception(Integer.parseInt(percRank.getText()));
		rpgChar.setAgility(Integer.parseInt(agilRank.getText()));
		rpgChar.setIntelligence(Integer.parseInt(inteRank.getText()));
		rpgChar.setReflexes(Integer.parseInt(reflRank.getText()));
		rpgChar.setAwareness(Integer.parseInt(awarRank.getText()));
		rpgChar.setVoidRing(Integer.parseInt(voidRank.getText()));
		rpgChar.calcRings();
	}

	public void updateRingsBox() {
		earthRank.setText(rpgChar.getEarthRing() + "");
		airRank.setText(rpgChar.getAirRing() + "");
		waterRank.setText(rpgChar.getWaterRing() + "");
		fireRank.setText(rpgChar.getFireRing() + "");
				
	}

	@Override
	public void dataUpdated() {
		updateRingsBox();
				
	}

	@Override
	public void loadNewCharacter() {
		// TODO put rpgchar data into fields
		
	}

	
}