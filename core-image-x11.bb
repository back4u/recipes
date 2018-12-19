require recipes-graphics/images/core-image-x11.bb

DESCRIPTION="This image inherits core-image-x11 and adds features and packages."

IMAGE_FEATURES_append = " debug-tweaks \ 
                          eclipse-debug \
                	  ssh-server-openssh \
                        "

IMAGE_INSTALL_append = " boost \
                         opencv \
                         dlib \
                         ffmpeg \
			 gidi \
                       "
