package GameStates;

import GameEngine.Game;
import GameEngine.GameManager;
import Meteor.GameEngine.Manager;
import Meteor.Graphics.Context;
import Meteor.States.State;
import Meteor.States.StateManager;
import Meteor.System.Asset.AssetManager;
import Utilities.ResourceLoader;

public class LoadingState extends State {

    public LoadingState(StateManager stateManager) {
        super("loadingState", stateManager);
        init();
    }

    @Override public void init() {
        GameManager gameManager = Game.getGameManager();

        ResourceLoader.load();

        gameManager.setAssetManager(AssetManager.getInstance());
    }

    @Override public void update(Manager manager, double delta) {
    	if(AssetManager.isLoaded()) stateManager.push(new GameState(stateManager));
    }

    @Override public void render(Manager manager, Context ctx) {}
}