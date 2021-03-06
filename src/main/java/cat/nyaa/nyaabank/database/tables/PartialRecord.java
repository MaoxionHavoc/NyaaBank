package cat.nyaa.nyaabank.database.tables;

import cat.nyaa.nyaabank.database.enums.TransactionType;
import cat.nyaa.nyaacore.database.DataColumn;
import cat.nyaa.nyaacore.database.DataTable;
import cat.nyaa.nyaacore.database.PrimaryKey;

import java.time.Instant;
import java.util.UUID;

/* New deposit or loan */
@DataTable("partial_transactions")
public class PartialRecord {
    // Data column names
    public static final String N_CAPITAL = "capital";
    public static final String N_TRANSACTION_ID = "transaction_id";
    public static final String N_BANK_ID = "bank_id";
    public static final String N_PLAYER_ID = "player_id";
    public static final String N_START_DATE = "start_date";
    public static final String N_TRANSACTION_TYPE = "transaction_type";

    public UUID transactionId;
    public UUID bankId;
    public UUID playerId;
    public Instant startDate; // Stored as Unix timestamp ms
    @DataColumn(N_CAPITAL)
    public Double capital;
    public TransactionType type; // deposit or loan

    @DataColumn(N_TRANSACTION_ID)
    @PrimaryKey
    public String getTransactionId() {
        return transactionId.toString();
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = UUID.fromString(transactionId);
    }

    @DataColumn(N_BANK_ID)
    public String getBankId() {
        return bankId.toString();
    }

    public void setBankId(String bankId) {
        this.bankId = UUID.fromString(bankId);
    }

    @DataColumn(N_PLAYER_ID)
    public String getPlayerId() {
        return playerId.toString();
    }

    public void setPlayerId(String playerId) {
        this.playerId = UUID.fromString(playerId);
    }

    @DataColumn(N_START_DATE)
    public Long getStartDate() {
        return startDate.toEpochMilli();
    }

    public void setStartDate(Long startDate) {
        this.startDate = Instant.ofEpochMilli(startDate);
    }

    @DataColumn(N_TRANSACTION_TYPE)
    public String getType() {
        return type.toString();
    }

    public void setType(String type) {
        this.type = TransactionType.valueOf(type);
    }
}
