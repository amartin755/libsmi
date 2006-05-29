/*
 * This Java file has been generated by smidump 0.4.5. Do not edit!
 * It is intended to be used within a Java AgentX sub-agent environment.
 *
 * $Id$
 */

/**
    This class represents a Java AgentX (JAX) implementation of
    the table row usrHistoryEntry defined in RMON2-MIB.

    @version 1
    @author  smidump 0.4.5
    @see     AgentXTable, AgentXEntry
 */

import jax.AgentXOID;
import jax.AgentXSetPhase;
import jax.AgentXResponsePDU;
import jax.AgentXEntry;

public class UsrHistoryEntry extends AgentXEntry
{

    protected int usrHistorySampleIndex = 0;
    protected long usrHistoryIntervalStart = 0;
    protected long usrHistoryIntervalEnd = 0;
    protected long usrHistoryAbsValue = 0;
    protected int usrHistoryValStatus = 0;
    // foreign indices
    protected int usrHistoryControlIndex;
    protected int usrHistoryObjectIndex;

    public UsrHistoryEntry(int usrHistoryControlIndex,
                           int usrHistorySampleIndex,
                           int usrHistoryObjectIndex)
    {
        this.usrHistoryControlIndex = usrHistoryControlIndex;
        this.usrHistorySampleIndex = usrHistorySampleIndex;
        this.usrHistoryObjectIndex = usrHistoryObjectIndex;

        instance.append(usrHistoryControlIndex);
        instance.append(usrHistorySampleIndex);
        instance.append(usrHistoryObjectIndex);
    }

    public int get_usrHistoryControlIndex()
    {
        return usrHistoryControlIndex;
    }

    public int get_usrHistorySampleIndex()
    {
        return usrHistorySampleIndex;
    }

    public int get_usrHistoryObjectIndex()
    {
        return usrHistoryObjectIndex;
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

