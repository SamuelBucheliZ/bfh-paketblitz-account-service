package ch.bfh.paketblitz.api;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class AccountEndpoint {

    private static final String NO_PERMISSIONS_ACCOUNT_NAME = "noPermissions";
    private static final String ONLY_ECONOMY_PERMISSIONS_ACCOUNT_NAME = "onlyEconomy";
    private static final String ONLY_PREMIUM_PERMISSION_ACCOUNT_NAME = "onlyPremium";
    private static final String ALL_PERMISSIONS_ACCOUNT_NAME = "allPermissions";

    private static final List<AccountResponse> ACCOUNTS = Arrays.asList(
            new AccountResponse(1111, NO_PERMISSIONS_ACCOUNT_NAME, Collections.emptyList()),
            new AccountResponse(2222, ONLY_ECONOMY_PERMISSIONS_ACCOUNT_NAME, Collections.singletonList(ServiceType.ECONOMY)),
            new AccountResponse(3333, ONLY_PREMIUM_PERMISSION_ACCOUNT_NAME, Collections.singletonList(ServiceType.PREMIUM)),
            new AccountResponse(4444, ALL_PERMISSIONS_ACCOUNT_NAME, Arrays.asList(ServiceType.ECONOMY, ServiceType.PREMIUM))
    );

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "get all accounts")
    public List<AccountResponse> getAccounts() {
        return ACCOUNTS;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/accounts/{accountName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "get single account")
    public AccountResponse getAccount(@PathVariable("accountName") String accountName) {
        return ACCOUNTS.stream()
                .filter(accountResponse -> accountResponse.getAccountName().equals(accountName))
                .findAny()
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }
}
