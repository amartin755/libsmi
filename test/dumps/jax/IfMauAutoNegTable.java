/*
 * This Java file has been generated by smidump 0.2.10. Do not edit!
 * It is intended to be used within a Java AgentX sub-agent environment.
 *
 * $Id$
 */

/**
    This class represents a Java AgentX (JAX) implementation of
    the table ifMauAutoNegTable defined in MAU-MIB.

    @version 1
    @author  smidump 0.2.10
    @see     AgentXTable
 */

import java.util.Vector;

import jax.AgentXOID;
import jax.AgentXVarBind;
import jax.AgentXResponsePDU;
import jax.AgentXSetPhase;
import jax.AgentXTable;
import jax.AgentXEntry;

public class IfMauAutoNegTable extends AgentXTable
{

    // entry OID
    private final static long[] OID = {1, 3, 6, 1, 2, 1, 26, 5, 1, 1};

    // constructor
    public IfMauAutoNegTable()
    {
        oid = new AgentXOID(OID);

        // register implemented columns
        columns.addElement(new Long(1));
        columns.addElement(new Long(2));
        columns.addElement(new Long(4));
        columns.addElement(new Long(5));
        columns.addElement(new Long(6));
        columns.addElement(new Long(7));
        columns.addElement(new Long(8));
        columns.addElement(new Long(9));
        columns.addElement(new Long(10));
        columns.addElement(new Long(11));
        columns.addElement(new Long(12));
        columns.addElement(new Long(13));
    }

    public AgentXVarBind getVarBind(AgentXEntry entry, long column)
    {
        AgentXOID oid = new AgentXOID(getOID(), column, entry.getInstance());

        switch ((int)column) {
        case 1: // ifMauAutoNegAdminStatus
        {
            int value = ((IfMauAutoNegEntry)entry).get_ifMauAutoNegAdminStatus();
            return new AgentXVarBind(oid, AgentXVarBind.INTEGER, value);
        }
        case 2: // ifMauAutoNegRemoteSignaling
        {
            int value = ((IfMauAutoNegEntry)entry).get_ifMauAutoNegRemoteSignaling();
            return new AgentXVarBind(oid, AgentXVarBind.INTEGER, value);
        }
        case 4: // ifMauAutoNegConfig
        {
            int value = ((IfMauAutoNegEntry)entry).get_ifMauAutoNegConfig();
            return new AgentXVarBind(oid, AgentXVarBind.INTEGER, value);
        }
        case 5: // ifMauAutoNegCapability
        {
            int value = ((IfMauAutoNegEntry)entry).get_ifMauAutoNegCapability();
            return new AgentXVarBind(oid, AgentXVarBind.INTEGER, value);
        }
        case 6: // ifMauAutoNegCapAdvertised
        {
            int value = ((IfMauAutoNegEntry)entry).get_ifMauAutoNegCapAdvertised();
            return new AgentXVarBind(oid, AgentXVarBind.INTEGER, value);
        }
        case 7: // ifMauAutoNegCapReceived
        {
            int value = ((IfMauAutoNegEntry)entry).get_ifMauAutoNegCapReceived();
            return new AgentXVarBind(oid, AgentXVarBind.INTEGER, value);
        }
        case 8: // ifMauAutoNegRestart
        {
            int value = ((IfMauAutoNegEntry)entry).get_ifMauAutoNegRestart();
            return new AgentXVarBind(oid, AgentXVarBind.INTEGER, value);
        }
        case 9: // ifMauAutoNegCapabilityBits
        {
            byte[] value = ((IfMauAutoNegEntry)entry).get_ifMauAutoNegCapabilityBits();
            return new AgentXVarBind(oid, AgentXVarBind.OCTETSTRING, value);
        }
        case 10: // ifMauAutoNegCapAdvertisedBits
        {
            byte[] value = ((IfMauAutoNegEntry)entry).get_ifMauAutoNegCapAdvertisedBits();
            return new AgentXVarBind(oid, AgentXVarBind.OCTETSTRING, value);
        }
        case 11: // ifMauAutoNegCapReceivedBits
        {
            byte[] value = ((IfMauAutoNegEntry)entry).get_ifMauAutoNegCapReceivedBits();
            return new AgentXVarBind(oid, AgentXVarBind.OCTETSTRING, value);
        }
        case 12: // ifMauAutoNegRemoteFaultAdvertised
        {
            int value = ((IfMauAutoNegEntry)entry).get_ifMauAutoNegRemoteFaultAdvertised();
            return new AgentXVarBind(oid, AgentXVarBind.INTEGER, value);
        }
        case 13: // ifMauAutoNegRemoteFaultReceived
        {
            int value = ((IfMauAutoNegEntry)entry).get_ifMauAutoNegRemoteFaultReceived();
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
        case 1: // ifMauAutoNegAdminStatus
        {
            if (vb.getType() != AgentXVarBind.INTEGER)
                return AgentXResponsePDU.WRONG_TYPE;
            else
                return ((IfMauAutoNegEntry)entry).set_ifMauAutoNegAdminStatus(phase, vb.intValue());
        }
        case 6: // ifMauAutoNegCapAdvertised
        {
            if (vb.getType() != AgentXVarBind.INTEGER)
                return AgentXResponsePDU.WRONG_TYPE;
            else
                return ((IfMauAutoNegEntry)entry).set_ifMauAutoNegCapAdvertised(phase, vb.intValue());
        }
        case 8: // ifMauAutoNegRestart
        {
            if (vb.getType() != AgentXVarBind.INTEGER)
                return AgentXResponsePDU.WRONG_TYPE;
            else
                return ((IfMauAutoNegEntry)entry).set_ifMauAutoNegRestart(phase, vb.intValue());
        }
        case 10: // ifMauAutoNegCapAdvertisedBits
        {
            if (vb.getType() != AgentXVarBind.OCTETSTRING)
                return AgentXResponsePDU.WRONG_TYPE;
            else
                return ((IfMauAutoNegEntry)entry).set_ifMauAutoNegCapAdvertisedBits(phase, vb.bytesValue());
        }
        case 12: // ifMauAutoNegRemoteFaultAdvertised
        {
            if (vb.getType() != AgentXVarBind.INTEGER)
                return AgentXResponsePDU.WRONG_TYPE;
            else
                return ((IfMauAutoNegEntry)entry).set_ifMauAutoNegRemoteFaultAdvertised(phase, vb.intValue());
        }
        }

        return AgentXResponsePDU.NOT_WRITABLE;
    }

}

