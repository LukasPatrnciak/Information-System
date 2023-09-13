package sk.lukaspatrnciak.informationsystem.data;

import sk.lukaspatrnciak.informationsystem.data.contract.service.ContractService;
import sk.lukaspatrnciak.informationsystem.data.user.service.UserService;

public class InformationSystem {

    private UserService userService;
    private ContractService contractService;

    public InformationSystem(UserService userService, ContractService contractService) {
        this.userService = userService;
        this.contractService = contractService;
    }

    // Setters
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }

    // Getters
    public UserService getUserService() {
        return userService;
    }

    public ContractService getContractService() {
        return contractService;
    }
}