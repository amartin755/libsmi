/*
 * This Java file has been generated by smidump 0.2.7. It
 * is intended to be edited by the application programmer and
 * to be used within a Java AgentX sub-agent environment.
 *
 * $Id$
 */

/**
    This class extends the Java AgentX (JAX) implementation of
    the table row usrHistoryEntry defined in RMON2-MIB.
 */

import jax.AgentXOID;
import jax.AgentXSetPhase;
import jax.AgentXResponsePDU;
import jax.AgentXEntry;

public class UsrHistoryEntryImpl extends UsrHistoryEntry
{

    // constructor
    public UsrHistoryEntryImpl(int usrHistoryControlIndex,
                           int usrHistorySampleIndex,
                           int usrHistoryObjectIndex)
    {
        super(usrHistoryControlIndex,
                 usrHistorySampleIndex,
                 usrHistoryObjectIndex);
    }

    public long get_usrHistoryIntervalStart()
    {
        return usrHistoryIntervalStart;
    }

    public long get_usrHistoryIntervalEnd()
    {
        return usrHistoryIntervalEnd;
    }

    public long get_usrHistoryAbsValue()
    {
        return usrHistoryAbsValue;
    }

    public int get_usrHistoryValStatus()
    {
        return usrHistoryValStatus;
    }

}

