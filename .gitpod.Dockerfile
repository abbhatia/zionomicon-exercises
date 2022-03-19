FROM gitpod/workspace-full

RUN curl -fL "$(curl -w "%{url_effective}\n" -I -L -s -S https://git.io/coursier-cli-"$(uname | tr LD ld)" -o /dev/null).gz" | gzip -d > cs && \
    chmod +x cs && \
    ./cs install cs && \
    echo 'export PATH="$PATH:/home/gitpod/.local/share/coursier/bin"' >> ~/.zshrc && \
    echo 'export PATH="$PATH:/home/gitpod/.local/share/coursier/bin"' >> ~/.bashrc && \
    ./cs install scala sbt scalafix scalafmt ammonite && \
    ./cs install bloop --only-prebuilt=true && \
    rm cs

RUN sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)" "" --unattended
