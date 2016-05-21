package com.templates.sanchellios.countries.data.database;

import com.templates.sanchellios.countries.country.ContinentConst;

import java.util.HashMap;

/**
 * Created by aleksandrvasilenko on 18.05.16.
 */
public class ContinentsWhereStmtCreator {
    private StringBuilder whereStatement;
    private boolean isFirst = true;

    public ContinentsWhereStmtCreator(){
        this.whereStatement = new StringBuilder();
    }

    public String getWhereStatement(HashMap<String, Boolean> continentStatuses){
        if(continentStatuses.get(ContinentConst.AFRICA))
            addAfrica();
        if(continentStatuses.get(ContinentConst.ASIA))
            addAsia();
        if(continentStatuses.get(ContinentConst.EUROPE))
            addEurope();
        if(continentStatuses.get(ContinentConst.AUSTRALIA_AND_OCEANIA))
            addAustralia();
        if(continentStatuses.get(ContinentConst.NORTH_AMERICA))
            addNorthAmerica();
        if(continentStatuses.get(ContinentConst.SOUTH_AMERICA))
            addSouthAmerica();
        return whereStatement.toString();
    }

    private void addAfrica(){
        checkIfJustStartedToAdd(this.whereStatement);
        addContinentValue(whereStatement, ContinentConst.AFRICA);
    }

    private void addEurope(){
        checkIfJustStartedToAdd(this.whereStatement);
        addContinentValue(whereStatement, ContinentConst.EUROPE);
    }

    private void addAustralia(){
        checkIfJustStartedToAdd(this.whereStatement);
        addContinentValue(whereStatement, ContinentConst.AUSTRALIA_AND_OCEANIA);
    }

    private void addAsia(){
        checkIfJustStartedToAdd(this.whereStatement);
        addContinentValue(whereStatement, ContinentConst.ASIA);
    }

    private void addNorthAmerica(){
        checkIfJustStartedToAdd(this.whereStatement);
        addContinentValue(whereStatement, ContinentConst.NORTH_AMERICA);
    }

    public void addSouthAmerica(){
        checkIfJustStartedToAdd(this.whereStatement);
        addContinentValue(whereStatement, ContinentConst.SOUTH_AMERICA);
    }

    private void checkIfJustStartedToAdd(StringBuilder builder){
        if(isFirst()){
            addWHERE(builder);
        }else {
            addOR(builder);
        }
    }

    private boolean isFirst(){
        if(isFirst){
            return true;
        }else {
            return false;
        }
    }

    private void addWHERE(StringBuilder builder){
        builder.append("WHERE ");
        isFirst = false;
    }

    private void addOR(StringBuilder builder){
        builder.append("OR ");
    }

    private void addContinentValue(StringBuilder builder, String value){
        String CONTINENT_COL = DbContracts.CountryTable.CONTINENT;
        builder.append(CONTINENT_COL).append("='").append(value).append("' ");
    }
}
