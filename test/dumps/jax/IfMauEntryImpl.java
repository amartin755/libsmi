/*
 * This Java file has been generated by smidump 0.2.11. It
 * is intended to be edited by the application programmer and
 * to be used within a Java AgentX sub-agent environment.
 *
 * $Id$
 */

/**
    This class extends the Java AgentX (JAX) implementation of
    the table row ifMauEntry defined in MAU-MIB.
 */

import jax.AgentXOID;
import jax.AgentXSetPhase;
import jax.AgentXResponsePDU;
import jax.AgentXEntry;

public class IfMauEntryImpl extends IfMauEntry
{

    // constructor
    public IfMauEntryImpl(int ifMauIfIndex,
                      int ifMauIndex)
    {
        super(ifMauIfIndex,
            ifMauIndex);
    }

    public int get_ifMauIfIndex()
    {
        return ifMauIfIndex;
    }

    public int get_ifMauIndex()
    {
        return ifMauIndex;
    }

    public AgentXOID get_ifMauType()
    {
        return ifMauType;
    }

    public int get_ifMauStatus()
    {
        return ifMauStatus;
    }

    public int set_ifMauStatus(AgentXSetPhase phase, int value)
    {
        switch (phase.getPhase()) {
        case AgentXSetPhase.TEST_SET:
            break;
        case AgentXSetPhase.COMMIT:
            undo_ifMauStatus = ifMauStatus;
            ifMauStatus = value;
            break;
        case AgentXSetPhase.UNDO:
            ifMauStatus = undo_ifMauStatus;
            break;
        case AgentXSetPhase.CLEANUP:
            break;
        default:
            return AgentXResponsePDU.PROCESSING_ERROR;
        }
        return AgentXResponsePDU.NO_ERROR;
    }
    public int get_ifMauMediaAvailable()
    {
        return ifMauMediaAvailable;
    }

    public long get_ifMauMediaAvailableStateExits()
    {
        return ifMauMediaAvailableStateExits;
    }

    public int get_ifMauJabberState()
    {
        return ifMauJabberState;
    }

    public long get_ifMauJabberingStateEnters()
    {
        return ifMauJabberingStateEnters;
    }

    public long get_ifMauFalseCarriers()
    {
        return ifMauFalseCarriers;
    }

    public int get_ifMauTypeList()
    {
        return ifMauTypeList;
    }

    public AgentXOID get_ifMauDefaultType()
    {
        return ifMauDefaultType;
    }

    public int set_ifMauDefaultType(AgentXSetPhase phase, AgentXOID value)
    {
        switch (phase.getPhase()) {
        case AgentXSetPhase.TEST_SET:
            break;
        case AgentXSetPhase.COMMIT:
            undo_ifMauDefaultType = ifMauDefaultType;
            ifMauDefaultType = value;
            break;
        case AgentXSetPhase.UNDO:
            ifMauDefaultType = undo_ifMauDefaultType;
            break;
        case AgentXSetPhase.CLEANUP:
            break;
        default:
            return AgentXResponsePDU.PROCESSING_ERROR;
        }
        return AgentXResponsePDU.NO_ERROR;
    }
    public int get_ifMauAutoNegSupported()
    {
        return ifMauAutoNegSupported;
    }

    public byte[] get_ifMauTypeListBits()
    {
        return ifMauTypeListBits;
    }

}

