package legendsWeb.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class LegendsWeb implements EntryPoint {
	private RPGCharacter rpgChar = new RPGCharacter();
	private FlexTable mainPanel = new FlexTable();
	private Panel ringsAndTraitsPanel;
	private Panel infoPanel;
	private Panel woundsPanel;
	

	@Override
	public void onModuleLoad() {
		rpgChar.clearListener();
				
		TopPanel topPanel = new TopPanel();
		ringsAndTraitsPanel = topPanel.createTopPanel(rpgChar); 
		rpgChar.addListener(topPanel);
		
		InfoPanel topInfoPanel = new InfoPanel();
		infoPanel = topInfoPanel.createInfoPanel(rpgChar);
		//rpgChar.addListener(topInfoPanel);
		
		WoundsPanel rightPanel = new WoundsPanel();
		woundsPanel = rightPanel.createWoundsPanel(rpgChar);
		woundsPanel.addStyleName("woundTable");
		rpgChar.addListener(rightPanel);

		mainPanel.setWidget(0, 1, woundsPanel);
		mainPanel.getFlexCellFormatter().setRowSpan(0, 1, 2);
		mainPanel.setWidget(0, 0, infoPanel);
		mainPanel.setWidget(1, 0, ringsAndTraitsPanel);
		PopupPanel popup = new PopupPanel();
		popup.setWidget(new Label("Popup!"));
		mainPanel.setWidget(2, 0, popup);
		
		RootPanel.get("l5rsheet").add(mainPanel);

	}
}