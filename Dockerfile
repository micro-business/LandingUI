FROM microbusiness/uihost-service
MAINTAINER micro.business.limited@gmail.com
ADD resources/public/index.html /www/
ADD resources/public/js/compiled/microbusinessweb.js /www/js/compiled/
CMD ["/UIHostService"]