package org.telegram.telegrambots.meta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TelegramUrl {
    private String schema;
    private String host;
    private int port;
    private boolean testServer;

    public static final TelegramUrl DEFAULT_URL = new TelegramUrl("https", getProxyHost(), getProxyPort(), false);

    private static int getProxyPort() {
        String value = System.getenv("PROXY_PORT");
        if (value == null) {
            throw new IllegalStateException("PROXY_PORT not set");
        }
        return Integer.parseInt(value);
    }

    private static String getProxyHost() {
        String value = System.getenv("PROXY_HOST");
        if (value == null) {
            throw new IllegalStateException("PROXY_HOST not set");
        }
        return value;
    }
}
