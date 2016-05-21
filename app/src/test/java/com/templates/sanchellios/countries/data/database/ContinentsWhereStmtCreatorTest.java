package com.templates.sanchellios.countries.data.database;

import com.templates.sanchellios.countries.country.ContinentConst;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by aleksandrvasilenko on 19.05.16.
 */
public class ContinentsWhereStmtCreatorTest {

    private ContinentsWhereStmtCreator creator;
    private HashMap<String, Boolean> stats;

    @Before
    public void setUp() throws Exception {
        creator = new ContinentsWhereStmtCreator();
    }

    @Test
    public void testAfricaOnly(){
        stats = getStats(true, false, false, false, false, false);
        String africaOnly = "WHERE " + DbContracts.CountryTable.CONTINENT + "='" + ContinentConst.AFRICA + "' ";
        Assert.assertEquals(africaOnly, creator.getWhereStatement(stats));
    }

    @Test
    public void testSeveralAdds(){
        stats = getStats(false, true, true, false, true, false);
        String europeORAsiaORNAmerica = "WHERE continent='Asia' OR continent='Europe' OR continent='North-America' ";
        Assert.assertEquals(europeORAsiaORNAmerica, creator.getWhereStatement(stats));
    }

    @Test
    public void testAll(){
        stats = getStats(true, true, true, true, true, true);
        String allStmts = "WHERE continent='Africa' OR continent='Asia' OR continent='Europe' OR continent='Australia-Oceania' OR continent='North-America' OR continent='South-America' ";
        Assert.assertEquals(allStmts, creator.getWhereStatement(stats));
    }

    @After
    public void tearDown() throws Exception {

    }

    private HashMap<String, Boolean> getStats(boolean africa,
                                              boolean asia,
                                              boolean europe,
                                              boolean australia,
                                              boolean n_america,
                                              boolean s_america){
        HashMap<String, Boolean> stats = new HashMap<>();
        stats.put(ContinentConst.AFRICA, africa);
        stats.put(ContinentConst.ASIA, asia);
        stats.put(ContinentConst.EUROPE, europe);
        stats.put(ContinentConst.AUSTRALIA_AND_OCEANIA, australia);
        stats.put(ContinentConst.NORTH_AMERICA, n_america);
        stats.put(ContinentConst.SOUTH_AMERICA, s_america);
        return stats;
    }
}