/*
 * This Java file has been generated by smidump 0.2.13. Do not edit!
 * It is intended to be used within a Java AgentX sub-agent environment.
 *
 * $Id$
 */

/**
    This class represents a Java AgentX (JAX) implementation of
    the table row sysOREntry defined in SNMPv2-MIB.

    @version 1
    @author  smidump 0.2.13
    @see     AgentXTable, AgentXEntry
 */

import jax.AgentXOID;
import jax.AgentXSetPhase;
import jax.AgentXResponsePDU;
import jax.AgentXEntry;

public class SysOREntry extends AgentXEntry
{

    protected int sysORIndex = 0;
    protected AgentXOID sysORID = new AgentXOID();
    protected byte[] sysORDescr = new byte[0];
    protected long sysORUpTime = 0;

    public SysOREntry(int sysORIndex)
    {
        this.sysORIndex = sysORIndex;

        instance.append(sysORIndex);
    }

    public int get_sysORIndex()
    {
        return sysORIndex;
    }

    public AgentXOID get_sysORID()
    {
        return sysORID;
    }

    public byte[] get_sysORDescr()
    {
        return sysORDescr;
    }

    public long get_sysORUpTime()
    {
        return sysORUpTime;
    }

}

