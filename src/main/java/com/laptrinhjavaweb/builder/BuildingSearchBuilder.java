package com.laptrinhjavaweb.builder;

public class BuildingSearchBuilder {
    private BuildingSearchBuilder(Builder builder) {
        this.name = builder.name;
        this.ward = builder.ward;
        this.street = builder.street;
        this.floorArea = builder.floorArea;;
        this.numberOfBasement = builder.numberOfBasement;
        this.areaRentFrom = builder.areaRentFrom;
        this.areaRentTo = builder.areaRentTo;
        this.costRentFrom = builder.areaRentFrom;
        this.costRentTo = builder.costRentTo;
        this.types = builder.types;
        this.staffId = builder.staffId;
    }

    private String name;
    private String ward;
    private String street;
    private Integer floorArea;
    private Integer numberOfBasement;
    private Integer areaRentFrom;
    private Integer areaRentTo;
    private Integer costRentFrom;
    private Integer costRentTo;
    private String[] types = new String[]{};
    private Long staffId;

    public Long getStaffId() {
        return staffId;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public String getName() {
        return name;
    }

    public String getWard() {
        return ward;
    }

    public String getStreet() {
        return street;
    }

    public Integer getAreaRentFrom() {
        return areaRentFrom;
    }

    public Integer getAreaRentTo() {
        return areaRentTo;
    }

    public Integer getCostRentFrom() {
        return costRentFrom;
    }

    public Integer getCostRentTo() {
        return costRentTo;
    }

    public String[] getTypes() {
        return types;
    }

    public static class Builder {

        private String name;
        private String ward;
        private String street;
        private Integer floorArea;
        private Integer numberOfBasement;
        private Integer areaRentFrom;
        private Integer areaRentTo;
        private Integer costRentFrom;
        private Integer costRentTo;
        private String[] types = new String[]{};
        private Long staffId;

        public Builder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setFloorArea(Integer floorArea) {
            this.floorArea = floorArea;
            return this;
        }

        public Builder setNumberOfBasement(Integer numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }

        public Builder setAreaRentFrom(Integer areaRentFrom) {
            this.areaRentFrom = areaRentFrom;
            return this;
        }

        public Builder setAreaRentTo(Integer areaRentTo) {
            this.areaRentTo = areaRentTo;
            return this;
        }

        public Builder setCostRentFrom(Integer costRentFrom) {
            this.costRentFrom = costRentFrom;
            return this;
        }

        public Builder setCostRentTo(Integer costRentTo) {
            this.costRentTo = costRentTo;
            return this;
        }

        public Builder setTypes(String[] types) {
            this.types = types;
            return this;
        }

        public BuildingSearchBuilder build() {
            return new BuildingSearchBuilder(this);
        }

    }
}
