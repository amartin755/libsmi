/*
 * This Java file has been generated by smidump 0.2.11. Do not edit!
 * It is intended to be used within a Java AgentX sub-agent environment.
 *
 * $Id$
 */

/**
    This class represents a Java AgentX (JAX) implementation of
    the table broadMauBasicTable defined in MAU-MIB.

    @version 1
    @author  smidump 0.2.11
    @see     AgentXTable
 */

import java.util.Vector;

import jax.AgentXOID;
import jax.AgentXVarBind;
import jax.AgentXResponsePDU;
import jax.AgentXSetPhase;
import jax.AgentXTable;
import jax.AgentXEntry;

public class BroadMauBasicTable extends AgentXTable
{

    // entry OID
    private final static long[] OID = {1, 3, 6, 1, 2, 1, 26, 3, 1, 1};

    // constructor
    public BroadMauBasicTable()
    {
        oid = new AgentXOID(OID);

        // register implemented columns
        columns.addElement(new Long(1));
        columns.addElement(new Long(2));
        columns.addElement(new Long(3));
        columns.addElement(new Long(4));
        columns.addElement(new Long(5));
    }

    public AgentXVarBind getVarBind(AgentXEntry entry, long column)
    {
        AgentXOID oid = new AgentXOID(getOID(), column, entry.getInstance());

        switch ((int)column) {
        case 1: // broadMauIfIndex
        {
            int value = ((BroadMauBasicEntry)entry).get_broadMauIfIndex();
            return new AgentXVarBind(oid, AgentXVarBind.INTEGER, value);
        }
        case 2: // broadMauIndex
        {
            int value = ((BroadMauBasicEntry)entry).get_broadMauIndex();
            return new AgentXVarBind(oid, AgentXVarBind.INTEGER, value);
        }
        case 3: // broadMauXmtRcvSplitType
        {
            int value = ((BroadMauBasicEntry)entry).get_broadMauXmtRcvSplitType();
            return new AgentXVarBind(oid, AgentXVarBind.INTEGER, value);
        }
        case 4: // broadMauXmtCarrierFreq
        {
            int value = ((BroadMauBasicEntry)entry).get_broadMauXmtCarrierFreq();
            return new AgentXVarBind(oid, AgentXVarBind.INTEGER, value);
        }
        case 5: // broadMauTranslationFreq
        {
            int value = ((BroadMauBasicEntry)entry).get_broadMauTranslationFreq();
            return new AgentXVarBind(oid, AgentXVarBind.INTEGER, value);
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

