package me.Danker.commands;

import me.Danker.DankersSkyblockMod;
import me.Danker.features.CustomMusic;
import me.Danker.handlers.ConfigHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

import java.util.List;

public class ToggleCommand extends CommandBase implements ICommand {
	public static boolean gpartyToggled;
	public static boolean coordsToggled;
	public static boolean goldenToggled;
	public static boolean slayerCountTotal;
	public static boolean rngesusAlerts;
	public static boolean ghostDisplay;
	public static boolean splitFishing;
	public static boolean chatMaddoxToggled;
	public static boolean spiritBearAlerts;
	public static boolean petColoursToggled;
	public static boolean dungeonTimerToggled;
	public static boolean ghostTimerToggled;
	public static boolean golemAlertToggled;
	public static boolean expertiseLoreToggled;
	public static boolean skill50DisplayToggled;
	public static boolean outlineTextToggled;
	public static boolean cakeTimerToggled;
	public static boolean highlightSlayers;
	public static boolean highlightArachne;
	// Chat Messages
	public static boolean sceptreMessages;
	public static boolean midasStaffMessages;
	public static boolean implosionMessages;
	public static boolean healMessages;
	public static boolean cooldownMessages;
	public static boolean manaMessages;
	public static boolean killComboMessages;
	// Dungeons Messages
	public static boolean lowHealthNotifyToggled;
	public static boolean lividSolverToggled;
	public static boolean stopSalvageStarredToggled;
	public static boolean watcherReadyToggled;
	public static boolean swapToPickBlockToggled;
	public static boolean notifySlayerSlainToggled;
	public static boolean necronNotificationsToggled;
	public static boolean bonzoTimerToggled;
	public static boolean autoSkillTrackerToggled;
	// Puzzle Solvers
	public static boolean threeManToggled;
	public static boolean oruoToggled;
	public static boolean blazeToggled;
	public static boolean creeperToggled;
	public static boolean waterToggled;
	public static boolean ticTacToeToggled;
	public static boolean boulderToggled;
	public static boolean silverfishToggled;
	public static boolean iceWalkToggled;
	// Terminal Helpers
	public static boolean startsWithToggled;
	public static boolean selectAllToggled;
	public static boolean clickInOrderToggled;
	// Experiments
	public static boolean ultrasequencerToggled;
	public static boolean chronomatronToggled;
	public static boolean superpairsToggled;
	public static boolean hideTooltipsInExperimentAddonsToggled;
	public static boolean melodyTooltips;
	// Custom Music
	public static boolean dungeonBossMusic;
	public static boolean bloodRoomMusic;
	public static boolean dungeonMusic;

	@Override
	public String getCommandName() {
		return "toggle";
	}

	@Override
	public String getCommandUsage(ICommandSender arg0) {

		return "/" + getCommandName() + " <gparty/coords/golden/slayercount/rngesusalerts/splitfishing/ghostdisplay/chatmaddox/spiritbearalert/" +
										  "sceptremessages/petcolors/dungeontimer/golemalerts/expertiselore/" + //ghosttimer
										  "skill50display/outlinetext/midasstaffmessages/implosionmessages/healmessages/cooldownmessages/" +
										  "manamessages/killcombomessages/caketimer/lowhealthnotify/lividsolver/stopsalvagestarred/" +
										  "notifyslayerslain/necronnotifications/bonzotimer/threemanpuzzle/oruopuzzle/blazepuzzle/" +
										  "creeperpuzzle/waterpuzzle/tictactoepuzzle/boulderpuzzle/silverfishpuzzle/icewalkpuzzle/watchermessage/" +
										  "startswithterminal/selectallterminal/clickinorderterminal/" +
										  "ultrasequencer/chronomatron/superpairs/hidetooltipsinaddons/pickblock/" +
										  "melodytooltips/highlightslayers/highlightarachne/dungeonbossmusic/bloodroommusic/" +
										  "dungeonmusic/list>";
	}

	public static String usage(ICommandSender arg0) {
		return new ToggleCommand().getCommandUsage(arg0);
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}

	@Override
	public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
		if (args.length == 1) {
			return getListOfStringsMatchingLastWord(args, "gparty", "coords", "golden", "slayercount", "rngesusalerts", "highlightArachne",
														  "splitfishing", "chatmaddox", "spiritbearalerts",
														  "sceptremessages", "petcolors", "dungeontimer", "golemalerts",
														  "expertiselore", "skill50display", "outlinetext", "midasstaffmessages",
														  "implosionmessages", "healmessages", "cooldownmessages", "manamessages",
														  "killcombomessages", "caketimer", "lowhealthnotify", "autoskilltracker", "lividsolver",
														  "stopsalvagestarred", "notifyslayerslain", "necronnotifications",
														  "bonzotimer", "threemanpuzzle", "oruopuzzle", "blazepuzzle",
														  "creeperpuzzle", "waterpuzzle", "tictactoepuzzle", "boulderpuzzle",
														  "silverfishpuzzle", "icewalkpuzzle", "watchermessage", "startswithterminal",
														  "selectallterminal", "clickinorderterminal",
														  "ultrasequencer", "chronomatron", "superpairs",
														  "hidetooltipsinaddons", "pickblock", "melodytooltips", "highlightslayers",
														  "dungeonbossmusic", "bloodroommusic", "dungeonmusic", "list");
		}
		return null;
	}
	
	@Override
	public void processCommand(ICommandSender arg0, String[] arg1) throws CommandException {
		final EntityPlayer player = (EntityPlayer)arg0;
		
		if (arg1.length == 0) {
			player.addChatMessage(new ChatComponentText(DankersSkyblockMod.ERROR_COLOUR + "Usage: " + getCommandUsage(arg0)));
			return;
		}
		
		switch (arg1[0].toLowerCase()) {
			case "gparty":
				gpartyToggled = !gpartyToggled;
				ConfigHandler.writeBooleanConfig("toggles", "GParty", gpartyToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Guild party notifications has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + gpartyToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "coords":
				coordsToggled = !coordsToggled;
				ConfigHandler.writeBooleanConfig("toggles", "Coords", coordsToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Coord/Angle display has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + coordsToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "golden": 
				goldenToggled = !goldenToggled;
				ConfigHandler.writeBooleanConfig("toggles", "Golden", goldenToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Golden T6 enchants has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + goldenToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "slayercount":
				slayerCountTotal = !slayerCountTotal;
				ConfigHandler.writeBooleanConfig("toggles", "SlayerCount", slayerCountTotal);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Counting total 20% slayer drops has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + slayerCountTotal + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "rngesusalerts":
				rngesusAlerts = !rngesusAlerts;
				ConfigHandler.writeBooleanConfig("toggles", "RNGesusAlerts", rngesusAlerts);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Slayer RNGesus alerts has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + rngesusAlerts + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "ghostDisplay":
				ghostDisplay = !ghostDisplay;
				ConfigHandler.writeBooleanConfig("toggles", "GhostDisplay", ghostDisplay);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Ghost Display has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + ghostDisplay + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "splitfishing":
				splitFishing = !splitFishing;
				ConfigHandler.writeBooleanConfig("toggles", "SplitFishing", splitFishing);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Split fishing display has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + splitFishing + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "chatmaddox":
				chatMaddoxToggled = !chatMaddoxToggled;
				ConfigHandler.writeBooleanConfig("toggles", "ChatMaddox", chatMaddoxToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Click screen to open Maddox menu has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + chatMaddoxToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "spiritbearalerts":
				spiritBearAlerts = !spiritBearAlerts;
				ConfigHandler.writeBooleanConfig("toggles", "SpiritBearAlerts", spiritBearAlerts);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Spirit Bear alerts have been set to " + DankersSkyblockMod.SECONDARY_COLOUR + spiritBearAlerts + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "sceptremessages":
				sceptreMessages = !sceptreMessages;
				ConfigHandler.writeBooleanConfig("toggles", "SceptreMessages", sceptreMessages);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Spirit Sceptre messages have been set to " + DankersSkyblockMod.SECONDARY_COLOUR + sceptreMessages + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "midasstaffmessages":
				midasStaffMessages = !midasStaffMessages;
				ConfigHandler.writeBooleanConfig("toggles", "MidasStaffMessages", midasStaffMessages);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Midas Staff messages have been set to " + DankersSkyblockMod.SECONDARY_COLOUR + midasStaffMessages + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "implosionmessages":
				implosionMessages = !implosionMessages;
				ConfigHandler.writeBooleanConfig("toggles", "ImplosionMessages", implosionMessages);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Implosion messages have been set to " + DankersSkyblockMod.SECONDARY_COLOUR + implosionMessages + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "healmessages":
				healMessages = !healMessages;
				ConfigHandler.writeBooleanConfig("toggles", "HealMessages", healMessages);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Heal messages have been set to " + DankersSkyblockMod.SECONDARY_COLOUR + healMessages + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "cooldownmessages":
				cooldownMessages = !cooldownMessages;
				ConfigHandler.writeBooleanConfig("toggles", "CooldownMessages", cooldownMessages);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Ability cooldown messages has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + cooldownMessages + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "manamessages":
				manaMessages = !manaMessages;
				ConfigHandler.writeBooleanConfig("toggles", "ManaMessages", manaMessages);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Out of mana messages has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + manaMessages + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "killcombomessages":
				killComboMessages = !killComboMessages;
				ConfigHandler.writeBooleanConfig("toggles", "KillComboMessages", killComboMessages);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Kill combo messages has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + killComboMessages + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "petcolors":
			case "petcolours":
				petColoursToggled = !petColoursToggled;
				ConfigHandler.writeBooleanConfig("toggles", "PetColors", petColoursToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Pet colours have been set to " + DankersSkyblockMod.SECONDARY_COLOUR + petColoursToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "dungeontimer":
				dungeonTimerToggled = !dungeonTimerToggled;
				ConfigHandler.writeBooleanConfig("toggles", "DungeonTimer", dungeonTimerToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Dungeon timer has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + dungeonTimerToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			/*case "ghostTimer":
				ghostTimerToggled = !ghostTimerToggled;
				ConfigHandler.writeBooleanConfig("toggles", "GhostTimer", ghostTimerToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Ghost timer has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + ghostTimerToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break; */
			case "golemalerts":
				golemAlertToggled = !golemAlertToggled;
				ConfigHandler.writeBooleanConfig("toggles", "GolemAlerts", golemAlertToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Golem spawn alerts has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + golemAlertToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "expertiselore":
				expertiseLoreToggled = !expertiseLoreToggled;
				ConfigHandler.writeBooleanConfig("toggles", "ExpertiseLore", expertiseLoreToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Expertise in lore has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + expertiseLoreToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "skill50display":
				skill50DisplayToggled = !skill50DisplayToggled;
				ConfigHandler.writeBooleanConfig("toggles", "Skill50Display", skill50DisplayToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Skill 50 display has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + skill50DisplayToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "outlinetext":
				outlineTextToggled = !outlineTextToggled;
				ConfigHandler.writeBooleanConfig("toggles", "OutlineText", outlineTextToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Outline displayed text has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + outlineTextToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "caketimer":
				cakeTimerToggled = !cakeTimerToggled;
				ConfigHandler.writeBooleanConfig("toggles", "CakeTimer", cakeTimerToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Cake timer has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + cakeTimerToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "lowhealthnotify":
				lowHealthNotifyToggled = !lowHealthNotifyToggled;
				ConfigHandler.writeBooleanConfig("toggles", "LowHealthNotify", lowHealthNotifyToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Low health notify has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + lowHealthNotifyToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "lividsolver":
				lividSolverToggled = !lividSolverToggled;
				ConfigHandler.writeBooleanConfig("toggles", "LividSolver", lividSolverToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Livid solver has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + lividSolverToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "stopsalvagestarred":
				stopSalvageStarredToggled = !stopSalvageStarredToggled;
				ConfigHandler.writeBooleanConfig("toggles", "StopSalvageStarred", stopSalvageStarredToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Stop salvaging starred items has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + stopSalvageStarredToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "notifyslayerslain":
				notifySlayerSlainToggled = !notifySlayerSlainToggled;
				ConfigHandler.writeBooleanConfig("toggles", "NotifySlayerSlain", notifySlayerSlainToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Notify when slayer slain has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + notifySlayerSlainToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "necronnotifications":
				necronNotificationsToggled = !necronNotificationsToggled;
				ConfigHandler.writeBooleanConfig("toggles", "NecronNotifications", necronNotificationsToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Necron phase notifications has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + necronNotificationsToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "bonzotimer":
				bonzoTimerToggled = !bonzoTimerToggled;
				ConfigHandler.writeBooleanConfig("toggles", "BonzoTimer", bonzoTimerToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Bonzo's Mask timer has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + necronNotificationsToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "autoskilltracker":
				autoSkillTrackerToggled = !autoSkillTrackerToggled;
				ConfigHandler.writeBooleanConfig("toggles", "AutoSkillTracker", autoSkillTrackerToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Auto start/stop skill tracker has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + autoSkillTrackerToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "threemanpuzzle":
				threeManToggled = !threeManToggled;
				ConfigHandler.writeBooleanConfig("toggles", "ThreeManPuzzle", threeManToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Three man puzzle solver has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + threeManToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "oruopuzzle":
				oruoToggled = !oruoToggled;
				ConfigHandler.writeBooleanConfig("toggles", "OruoPuzzle", oruoToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Oruo trivia solver has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + oruoToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "blazepuzzle":
				blazeToggled = !blazeToggled;
				ConfigHandler.writeBooleanConfig("toggles", "BlazePuzzle", blazeToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Blaze puzzle solver has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + blazeToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "creeperpuzzle":
				creeperToggled = !creeperToggled;
				ConfigHandler.writeBooleanConfig("toggles", "CreeperPuzzle", creeperToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Creeper puzzle solver has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + creeperToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "waterpuzzle":
				waterToggled = !waterToggled;
				ConfigHandler.writeBooleanConfig("toggles", "WaterPuzzle", waterToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Water puzzle solver has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + waterToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "tictactoepuzzle":
				ticTacToeToggled = !ticTacToeToggled;
				ConfigHandler.writeBooleanConfig("toggles", "TicTacToePuzzle", ticTacToeToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Tic tac toe puzzle solver has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + ticTacToeToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "boulderpuzzle":
				boulderToggled = !boulderToggled;
				ConfigHandler.writeBooleanConfig("toggles", "BoulderPuzzle", boulderToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Boulder puzzle solver has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + boulderToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "silverfishpuzzle":
				silverfishToggled = !silverfishToggled;
				ConfigHandler.writeBooleanConfig("toggles", "SilverfishPuzzle", silverfishToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Silverfish puzzle solver has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + silverfishToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "icewalkpuzzle":
				iceWalkToggled = !iceWalkToggled;
				ConfigHandler.writeBooleanConfig("toggles", "IceWalkPuzzle", iceWalkToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Ice walk puzzle solver has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + iceWalkToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "watchermessage":
				watcherReadyToggled = !watcherReadyToggled;
				ConfigHandler.writeBooleanConfig("toggles", "WatcherReadyMessage", watcherReadyToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Display Watcher ready message has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + watcherReadyToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;	
			case "startswithterminal":
				startsWithToggled = !startsWithToggled;
				ConfigHandler.writeBooleanConfig("toggles", "StartsWithTerminal", startsWithToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Starts with letter terminal solver has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + startsWithToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "selectallterminal":
				selectAllToggled = !selectAllToggled;
				ConfigHandler.writeBooleanConfig("toggles", "SelectAllTerminal", selectAllToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Select all color items terminal solver has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + selectAllToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "clickinorderterminal":
				clickInOrderToggled = !clickInOrderToggled;
				ConfigHandler.writeBooleanConfig("toggles", "ClickInOrderTerminal", clickInOrderToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Click in order terminal helper has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + selectAllToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "ultrasequencer":
				ultrasequencerToggled = !ultrasequencerToggled;
				ConfigHandler.writeBooleanConfig("toggles", "UltraSequencer", ultrasequencerToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Ultrasequencer solver has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + ultrasequencerToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "chronomatron":
				chronomatronToggled = !chronomatronToggled;
				ConfigHandler.writeBooleanConfig("toggles", "Chronomatron", chronomatronToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Chronomatron solver has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + chronomatronToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "superpairs":
				superpairsToggled = !superpairsToggled;
				ConfigHandler.writeBooleanConfig("toggles", "Superpairs", superpairsToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Superpairs solver has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + superpairsToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "hidetooltipsinaddons":
				hideTooltipsInExperimentAddonsToggled = !hideTooltipsInExperimentAddonsToggled;
				ConfigHandler.writeBooleanConfig("toggles", "HideTooltipsInExperimentAddons", hideTooltipsInExperimentAddonsToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Hide tooltips in ultrasequencer and chronomatron has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + hideTooltipsInExperimentAddonsToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "pickblock":
				swapToPickBlockToggled = !swapToPickBlockToggled;
				ConfigHandler.writeBooleanConfig("toggles", "PickBlock", swapToPickBlockToggled);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Auto-swap to pick block has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + swapToPickBlockToggled + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "melodytooltips":
				melodyTooltips = !melodyTooltips;
				ConfigHandler.writeBooleanConfig("toggles", "MelodyTooltips", melodyTooltips);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Hide tooltips in Melody's Harp " + DankersSkyblockMod.SECONDARY_COLOUR + melodyTooltips + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "highlightslayers":
				highlightSlayers = !highlightSlayers;
				ConfigHandler.writeBooleanConfig("toggles", "HighlightSlayers", highlightSlayers);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Highlight Slayer Bosses " + DankersSkyblockMod.SECONDARY_COLOUR + highlightSlayers + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "highlightArachne":
				highlightArachne = !highlightArachne;
				ConfigHandler.writeBooleanConfig("toggles", "HighlightArachne", highlightArachne);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Highlight Arachne " + DankersSkyblockMod.SECONDARY_COLOUR + highlightArachne + DankersSkyblockMod.MAIN_COLOUR + "."));
			case "dungeonbossmusic":
				dungeonBossMusic = !dungeonBossMusic;
				CustomMusic.dungeonboss.stop();
				ConfigHandler.writeBooleanConfig("toggles", "DungeonBossMusic", dungeonBossMusic);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Custom dungeon boss music has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + dungeonBossMusic + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "bloodroommusic":
				bloodRoomMusic = !bloodRoomMusic;
				CustomMusic.bloodroom.stop();
				ConfigHandler.writeBooleanConfig("toggles", "BloodRoomMusic", bloodRoomMusic);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Custom blood room music has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + bloodRoomMusic + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "dungeonmusic":
				dungeonMusic = !dungeonMusic;
				CustomMusic.dungeon.stop();
				ConfigHandler.writeBooleanConfig("toggles", "DungeonMusic", dungeonMusic);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Custom dungeon music has been set to " + DankersSkyblockMod.SECONDARY_COLOUR + dungeonMusic + DankersSkyblockMod.MAIN_COLOUR + "."));
				break;
			case "list":
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.TYPE_COLOUR + "Guild party notifications: " + DankersSkyblockMod.VALUE_COLOUR + gpartyToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Coord/Angle display: " + DankersSkyblockMod.VALUE_COLOUR + coordsToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Golden T6 enchants: " + DankersSkyblockMod.VALUE_COLOUR + goldenToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Counting total 20% slayer drops: " + DankersSkyblockMod.VALUE_COLOUR + slayerCountTotal + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Slayer RNGesus alerts: " + DankersSkyblockMod.VALUE_COLOUR + rngesusAlerts + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Split fishing display: " + DankersSkyblockMod.VALUE_COLOUR + splitFishing + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Chat Maddox menu: " + DankersSkyblockMod.VALUE_COLOUR + chatMaddoxToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Spirit Bear alerts: " + DankersSkyblockMod.VALUE_COLOUR + spiritBearAlerts + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Spirit Sceptre messages: " + DankersSkyblockMod.VALUE_COLOUR + sceptreMessages + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Midas Staff messages: " + DankersSkyblockMod.VALUE_COLOUR + midasStaffMessages + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Implosion messages: " + DankersSkyblockMod.VALUE_COLOUR + implosionMessages + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Heal messages: " + DankersSkyblockMod.VALUE_COLOUR + healMessages + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Ability cooldown messages: " + DankersSkyblockMod.VALUE_COLOUR + cooldownMessages + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Out of mana messages: " + DankersSkyblockMod.VALUE_COLOUR + manaMessages + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Pet colours: " + DankersSkyblockMod.VALUE_COLOUR + petColoursToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Dungeon timer: " + DankersSkyblockMod.VALUE_COLOUR + dungeonTimerToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Golem spawn alerts: " + DankersSkyblockMod.VALUE_COLOUR + golemAlertToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Expertise in lore: " + DankersSkyblockMod.VALUE_COLOUR + expertiseLoreToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Skill 50 display: " + DankersSkyblockMod.VALUE_COLOUR + skill50DisplayToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Outline displayed text: " + DankersSkyblockMod.VALUE_COLOUR + outlineTextToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Cake timer: " + DankersSkyblockMod.VALUE_COLOUR + cakeTimerToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Low health notify: " + DankersSkyblockMod.VALUE_COLOUR + lowHealthNotifyToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Auto start/stop skill tracker: " + DankersSkyblockMod.VALUE_COLOUR + autoSkillTrackerToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Livid solver: " + DankersSkyblockMod.VALUE_COLOUR + lividSolverToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Three man puzzle solver: " + DankersSkyblockMod.VALUE_COLOUR + threeManToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Oruo trivia solver: " + DankersSkyblockMod.VALUE_COLOUR + oruoToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Blaze puzzle solver: " + DankersSkyblockMod.VALUE_COLOUR + blazeToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Creeper puzzle solver: " + DankersSkyblockMod.VALUE_COLOUR + creeperToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Water puzzle solver: " + DankersSkyblockMod.VALUE_COLOUR + waterToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Tic tac toe puzzle solver: " + DankersSkyblockMod.VALUE_COLOUR + ticTacToeToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Boulder puzzle solver: " + DankersSkyblockMod.VALUE_COLOUR + boulderToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Silverfish puzzle solver: " + DankersSkyblockMod.VALUE_COLOUR + silverfishToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Ice walk puzzle solver: " + DankersSkyblockMod.VALUE_COLOUR + iceWalkToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Watcher ready message: " + DankersSkyblockMod.VALUE_COLOUR + watcherReadyToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Starts with letter terminal solver: " + DankersSkyblockMod.VALUE_COLOUR + startsWithToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Select all color items terminal solver: " + DankersSkyblockMod.VALUE_COLOUR + selectAllToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Ultra sequencer solver: " + DankersSkyblockMod.VALUE_COLOUR + ultrasequencerToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Chronomatron solver: " + DankersSkyblockMod.VALUE_COLOUR + chronomatronToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Superpairs solver: " + DankersSkyblockMod.VALUE_COLOUR + superpairsToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Hide tooltips in experiment addons: " + DankersSkyblockMod.VALUE_COLOUR + hideTooltipsInExperimentAddonsToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Auto-swap to pick block " + DankersSkyblockMod.VALUE_COLOUR + swapToPickBlockToggled + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Hide tooltips in Melody's Harp " + DankersSkyblockMod.VALUE_COLOUR + melodyTooltips + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Highlight Slayer Bosses " + DankersSkyblockMod.VALUE_COLOUR + highlightSlayers + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Highlight Arachne Boss " + DankersSkyblockMod.VALUE_COLOUR + highlightArachne + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Custom dungeon boss music: " + DankersSkyblockMod.VALUE_COLOUR + dungeonBossMusic + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Custom blood room music: " + DankersSkyblockMod.VALUE_COLOUR + bloodRoomMusic + "\n" +
															DankersSkyblockMod.TYPE_COLOUR + " Custom dungeon music: " + DankersSkyblockMod.VALUE_COLOUR + dungeonMusic
				));
				break;
			default:
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.ERROR_COLOUR + "Usage: " + getCommandUsage(arg0)));
		}
	}
}
