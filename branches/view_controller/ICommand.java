package view_controller;

public interface ICommand {

	public void execute(Commands command,BusinessObjects object, Object currentObject);
}
