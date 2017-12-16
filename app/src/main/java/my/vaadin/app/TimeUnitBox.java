package my.vaadin.app;

import java.time.LocalDate;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class TimeUnitBox extends VerticalLayout{

	private List<Note> notes;
	private LocalDate start;
	private LocalDate end;
	
	//private String displayText;
	private final Button button;
	
	public TimeUnitBox(){
		super();
		button = new Button();
		this.addComponent(button);
	}
	
	public void update(){
		if(notes.size() > 0){
			button.setCaption("There are " + notes.size() + "notes here");
		}else{
			button.setCaption("(Empty)");
		}
	}
	
	public void addNote(Note note){
		this.notes.add(note);
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}
	
}
