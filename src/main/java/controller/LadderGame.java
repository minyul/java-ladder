package controller;

import domain.Number;
import domain.User;
import utils.Input;

import java.util.List;

public class LadderGame {
	public static void main(String[] args) {

		Input input = new Input();
		List<User> users = input.saveUsers();
		Number ladderCount = input.saveLadderCount();
	}
}

