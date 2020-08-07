package com.lambtoncollege.buildmypc.model;

public class BuildDesktop {
    private String buildDesktopID;
    private String processor;
    private String processorGen;
    private String ram;
    private String storageType;
    private String graphicCard;
    private String powerSupply;
    private String networkCard;
    private String cabinet;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBuildDesktopID() {
        return buildDesktopID;
    }

    public void setBuildDesktopID(String buildDesktopID) {
        this.buildDesktopID = buildDesktopID;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getProcessorGen() {
        return processorGen;
    }

    public void setProcessorGen(String processorGen) {
        this.processorGen = processorGen;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    public String getNetworkCard() {
        return networkCard;
    }

    public void setNetworkCard(String networkCard) {
        this.networkCard = networkCard;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }
}
