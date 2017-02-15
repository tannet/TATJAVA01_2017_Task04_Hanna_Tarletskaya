package com.epam.news.service.factory;

import com.epam.news.service.impl.PortalServiceImpl;
import com.epam.news.service.interfaces.PortalService;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final PortalService portalService = new PortalServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public PortalService getPortalService() {
        return portalService;
    }
}
