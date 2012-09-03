package com.activequant.messages;

import com.activequant.domainmodel.TimeStamp;
import com.activequant.domainmodel.streaming.MarketDataSnapshot;
import com.activequant.messages.AQMessages.BaseMessage;
import com.activequant.utils.ArrayUtils;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * Marshaller for MDS messages. 
 * @author GhostRider
 *
 */
public class MDSMarshaller {
	MessageFactory mf = new MessageFactory();

	ExtensionRegistry registry;

	public MDSMarshaller() {
		registry = ExtensionRegistry.newInstance();
		AQMessages.registerAllExtensions(registry);
	}

	public byte[] marshall(MarketDataSnapshot mds)
			throws InvalidProtocolBufferException {
		BaseMessage mdsm = mf.buildMds(mds.getMdiId(),
				ArrayUtils.toDoubleList(mds.getBidPrices()),
				ArrayUtils.toDoubleList(mds.getAskPrices()),
				ArrayUtils.toDoubleList(mds.getBidSizes()),
				ArrayUtils.toDoubleList(mds.getAskSizes()));
		return mdsm.toByteArray();
	}

	public AQMessages.BaseMessage demarshall(byte[] in)
			throws InvalidProtocolBufferException {
		return AQMessages.BaseMessage.parseFrom(in, registry);
	}

	public MarketDataSnapshot demarshall(AQMessages.MarketDataSnapshot mdsm) {
		MarketDataSnapshot mds = new MarketDataSnapshot();
		mds.setMdiId(mdsm.getMdiId());
		mds.setTimeStamp(new TimeStamp(mdsm.getTimestamp()));
		mds.setBidPrices(ArrayUtils.toPrimArray(mdsm.getBidPxList()));
		mds.setAskPrices(ArrayUtils.toPrimArray(mdsm.getAskPxList()));
		mds.setBidSizes(ArrayUtils.toPrimArray(mdsm.getBidQList()));
		mds.setAskSizes(ArrayUtils.toPrimArray(mdsm.getAskQList()));
		return mds;
	}

}
