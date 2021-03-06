package Controllers;

import Models.Initializer;
import Models.TabViewHelper;
import Models.TransactionsHistory;
import Public.Switcher;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;


public class Transactions extends Login {

    @FXML
    private Label account_user;

    @FXML
    private TableView<TransactionsHistory> transactions_view;

    @FXML
    private TableColumn<TransactionsHistory, String> TRANS_ID, TRANS_TYPE, TRANS_AMOUNT, TRANS_BALANCE, TRANS_DATE, TRANS_TIME;

    @FXML
    private TextField searching;

    public void initialize () throws SQLException {
        Initializer.init_transactions ( account_user, connect() );

        TabViewHelper.table_view(transactions_view);

        TRANS_ID.setCellValueFactory( new PropertyValueFactory<>("trans_id"));
        TRANS_TYPE.setCellValueFactory( new PropertyValueFactory<>("trans_type"));
        TRANS_AMOUNT.setCellValueFactory( new PropertyValueFactory<>("trans_amount"));
        TRANS_BALANCE.setCellValueFactory( new PropertyValueFactory<>("trans_balance"));
        TRANS_DATE.setCellValueFactory( new PropertyValueFactory<>("trans_date"));
        TRANS_TIME.setCellValueFactory( new PropertyValueFactory<>("trans_time"));

        TabViewHelper.table_search(transactions_view, searching);
    }

    @FXML
    private void refresh () throws SQLException { TabViewHelper.table_refresh(transactions_view); searching.clear(); TabViewHelper.table_search(transactions_view, searching); }

    @FXML
    private void accountBtn () throws IOException { Switcher.switcher("/Views/account.fxml"); }

    @FXML
    private void transactionsBtn () throws IOException { Switcher.switcher("/Views/transactions.fxml"); }

    @FXML
    private void settingsBtn () throws IOException { Switcher.switcher("/Views/settings.fxml"); }

    @FXML
    private void logoutBtn () throws IOException, SQLException { disconnect(); Switcher.switcher("/Views/login.fxml"); }

}
