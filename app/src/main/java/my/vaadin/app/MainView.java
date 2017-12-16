package my.vaadin.app;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class MainView extends VerticalLayout{

	private final CalendarView calendarView;
	
	private Life life;
	private ChronoUnit resolutionUnit;
	
	public MainView(){
		super();
		this.addComponent(new Label("This is the Main View"));
		calendarView = new CalendarView();
		this.addComponent(calendarView);
	}
	
	public void initialize(Life life, ChronoUnit resolutionUnit){
		this.life = life;
		this.resolutionUnit = resolutionUnit;
		
		calendarView.setResolutionUnit(resolutionUnit);
		calendarView.setLife(life);
		calendarView.updateView();
	}

	public Life getLife() {
		return life;
	}

	public void setLife(Life life) {
		this.life = life;
	}

	public ChronoUnit getResolutionUnit() {
		return resolutionUnit;
	}

	public void setResolutionUnit(ChronoUnit resolutionUnit) {
		this.resolutionUnit = resolutionUnit;
	}
	
}
