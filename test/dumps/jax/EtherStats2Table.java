/*
 * This Java file has been generated by smidump 0.2.13. Do not edit!
 * It is intended to be used within a Java AgentX sub-agent environment.
 *
 * $Id$
 */

/**
    This class represents a Java AgentX (JAX) implementation of
    the table etherStats2Table defined in RMON2-MIB.

    @version 1
    @author  smidump 0.2.13
    @see     AgentXTable
 */

import java.util.Vector;

import jax.AgentXOID;
import jax.AgentXVarBind;
import jax.AgentXResponsePDU;
import jax.AgentXSetPhase;
import jax.AgentXTable;
import jax.AgentXEntry;

public class EtherStats2Table extends AgentXTable
{

    // entry OID
    private final static long[] OID = {1, 3, 6, 1, 2, 1, 16, 1, 4, 1};

    // constructors
    public EtherStats2Table()
    {
        oid = new AgentXOID(OID);

        // register implemented columns
        columns.addElement(new Long(1));
        columns.addElement(new Long(2));
    }

    public EtherStats2Table(boolean shared)
    {
        super(shared);

        oid = new AgentXOID(OID);

        // register implemented columns
        columns.addElement(new Long(1));
        columns.addElement(new Long(2));
    }

    public AgentXVarBind getVarBind(AgentXEntry entry, long column)
    {
        AgentXOID oid = new AgentXOID(getOID(), column, entry.getInstance());

        switch ((int)column) {
        case 1: // etherStatsDroppedFrames
        {
            long value = ((EtherStats2Entry)entry).get_etherStatsDroppedFrames();
            return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, value);
        }
        case 2: // etherStatsCreateTime
        {
            long value = ((EtherStats2Entry)entry).get_etherStatsCreateTime();
            return new AgentXVarBind(oid, AgentXVarBind.GAUGE32, value);
        }
        }

        return null;
    }

    public int setEntry(AgentXSetPhase phase,
                        AgentXEntry entry,
                        long column,
                        AgentXVarBind vb)
    {

        switch ((int)column) {
        }

        return AgentXResponsePDU.NOT_WRITABLE;
    }

}

