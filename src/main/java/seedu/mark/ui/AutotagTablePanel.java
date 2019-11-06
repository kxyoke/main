package seedu.mark.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import seedu.mark.commons.core.LogsCenter;
import seedu.mark.model.autotag.SelectiveBookmarkTagger;

/**
 * Panel containing the list of bookmarks.
 */
public class AutotagTablePanel extends UiPart<Region> {
    private static final String FXML = "AutotagTablePanel.fxml";
    private final Logger logger = LogsCenter.getLogger(getClass());

    @FXML
    private TableView<SelectiveBookmarkTagger> autotagTableView;
    @FXML
    private TableColumn<SelectiveBookmarkTagger, String> tagColumn;
    @FXML
    private TableColumn<SelectiveBookmarkTagger, String> conditionsColumn;

    public AutotagTablePanel(ObservableList<SelectiveBookmarkTagger> autotagList) {
        super(FXML);
        logger.info("initialising AutotagTablePanel");

        tagColumn.setCellValueFactory(new PropertyValueFactory<>("tagToApply"));
        conditionsColumn.setCellValueFactory(new PropertyValueFactory<>("predicate"));

        autotagTableView.setItems(autotagList);
    }
}
