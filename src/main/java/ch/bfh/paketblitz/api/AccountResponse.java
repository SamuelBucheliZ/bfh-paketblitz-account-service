package ch.bfh.paketblitz.api;

import java.util.List;

public class AccountResponse {

    private final int accountId;
    private final String accountName;
    private final List<ServiceType> supportedServiceTypes;

    public AccountResponse(int accountId, String accountName, List<ServiceType> supportedServiceTypes) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.supportedServiceTypes = supportedServiceTypes;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public List<ServiceType> getSupportedServiceTypes() {
        return supportedServiceTypes;
    }
}
