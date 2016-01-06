package net.java.sip.communicator.impl.protocol.jabber.extensions.thumbnail;


import org.jivesoftware.smack.packet.*;
import org.jivesoftware.smack.provider.*;
import org.xmlpull.v1.*;

/**
 *
 */
public class ThumbnailIQProvider
    extends IQProvider
{
    /**
     * Parses the given <tt>XmlPullParser</tt> into a ThumbnailIQ packet and
     * returns it.
     * @see IQProvider#parseIQ(XmlPullParser)
     */
    public IQ parseIQ(XmlPullParser parser) throws Exception
    {
        String elementName = parser.getName();
        String namespace = parser.getNamespace();

        if (elementName.equals(ELEMENT_NAME)
            && namespace.equals(NAMESPACE))
        {
            this.cid = parser.getAttributeValue("", CID);
            this.mimeType = parser.getAttributeValue("", TYPE);
        }

        int eventType = parser.next();

        if (eventType == XmlPullParser.TEXT)
        {
            this.data = Base64.decode(parser.getText());
        }

        return this;
    }
}
