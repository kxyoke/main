package seedu.mark.logic.commands;

import static seedu.mark.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.mark.logic.commands.TabCommand.MESSAGE_SWITCH_ACKNOWLEDGEMENT;

import org.junit.jupiter.api.Test;

import seedu.mark.logic.commands.commandresult.CommandResult;
import seedu.mark.logic.commands.commandresult.TabCommandResult;
import seedu.mark.model.Model;
import seedu.mark.model.ModelManager;

class TabCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_tab_success() {
        CommandResult expectedCommandResult = new TabCommandResult(
                String.format(MESSAGE_SWITCH_ACKNOWLEDGEMENT, TabCommand.Tab.DASHBOARD.toString()),
                true, false, false);
        assertCommandSuccess(new TabCommand(TabCommand.Tab.DASHBOARD), model, expectedCommandResult, expectedModel);

        expectedCommandResult = new TabCommandResult(
                String.format(MESSAGE_SWITCH_ACKNOWLEDGEMENT, TabCommand.Tab.OFFLINE.toString()),
                false, false, true);
        assertCommandSuccess(new TabCommand(TabCommand.Tab.OFFLINE), model, expectedCommandResult, expectedModel);

        expectedCommandResult = new TabCommandResult(
                String.format(MESSAGE_SWITCH_ACKNOWLEDGEMENT, TabCommand.Tab.ONLINE.toString()),
                false, true, false);
        assertCommandSuccess(new TabCommand(TabCommand.Tab.ONLINE), model, expectedCommandResult, expectedModel);
    }

}
