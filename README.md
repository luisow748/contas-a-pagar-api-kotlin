<!-- markdownlint-configure-file {
  "MD013": {
    "code_blocks": false,
    "tables": false
  },
  "MD033": false,
  "MD041": false
} -->

<div align="center">

# zoxide

[![crates.io][crates.io-badge]][crates.io]
[![Downloads][downloads-badge]][releases]
[![Built with Nix][builtwithnix-badge]][builtwithnix]

zoxide is a **smarter cd command**, inspired by z and autojump.

It remembers which directories you use most frequently, so you can "jump" to
them in just a few keystrokes.<br />
zoxide works on all major shells.

[Getting started](#getting-started) •
[Installation](#installation) •
[Configuration](#configuration) •
[Integrations](#third-party-integrations)

</div>

## Getting started

![Tutorial][tutorial]

```sh
z foo              # cd into highest ranked directory matching foo
z foo bar          # cd into highest ranked directory matching foo and bar
z foo /            # cd into a subdirectory starting with foo
z ~/foo            # z also works like a regular cd command
z foo/             # cd into relative path
z ..               # cd one level up
z -                # cd into previous directory
zi foo             # cd with interactive selection (using fzf)
z foo<SPACE><TAB>  # show interactive completions (zoxide v0.8.0+, bash 4.4+/fish/zsh only)
```

Read more about the matching algorithm [here][algorithm-matching].

## Installation

zoxide can be installed in 4 easy steps:

1. **Install binary**

   zoxide runs on most major platforms. If your platform isn't listed below,
   please [open an issue][issues].

   <details>
   <summary>Linux</summary>

   > The recommended way to install zoxide is via the install script:
   >
   > ```sh
   > curl -sS https://raw.githubusercontent.com/ajeetdsouza/zoxide/main/install.sh | bash
   > ```
   >
   > Or, you can use a package manager:
   >
   > | Distribution        | Repository              | Instructions                                                                                          |
      > | ------------------- | ----------------------- | ----------------------------------------------------------------------------------------------------- |
   > | ***Any***           | **[crates.io]**         | `cargo install zoxide --locked`                                                                       |
   > | *Any*               | [asdf]                  | `asdf plugin add zoxide https://github.com/nyrst/asdf-zoxide.git` <br /> `asdf install zoxide latest` |
   > | *Any*               | [conda-forge]           | `conda install -c conda-forge zoxide`                                                                 |
   > | *Any*               | [Linuxbrew]             | `brew install zoxide`                                                                                 |
   > | Alpine Linux 3.13+  | [Alpine Linux Packages] | `apk add zoxide`                                                                                      |
   > | Arch Linux          | [Arch Linux Community]  | `pacman -S zoxide`                                                                                    |
   > | CentOS 7+           | [Copr]                  | `dnf copr enable atim/zoxide` <br /> `dnf install zoxide`                                             |
   > | Debian 11+[^1]      | [Debian Packages]       | `apt install zoxide`                                                                                  |
   > | Devuan 4.0+[^1]     | [Devuan Packages]       | `apt install zoxide`                                                                                  |
   > | Fedora 32+          | [Fedora Packages]       | `dnf install zoxide`                                                                                  |
   > | Gentoo              | [GURU Overlay]          | `eselect repository enable guru` <br /> `emerge --sync guru` <br /> `emerge app-shells/zoxide`        |
   > | Manjaro             |                         | `pacman -S zoxide`                                                                                    |
   > | NixOS 21.05+        | [nixpkgs]               | `nix-env -iA nixpkgs.zoxide`                                                                          |
   > | openSUSE Tumbleweed | [openSUSE Factory]      | `zypper install zoxide`                                                                               |
   > | Parrot OS[^1]       |                         | `apt install zoxide`                                                                                  |
   > | Raspbian 11+[^1]    | [Raspbian Packages]     | `apt install zoxide`                                                                                  |
   > | Slackware 15.0+     | [SlackBuilds]           | [Instructions][slackbuilds-howto]                                                                     |
   > | Ubuntu 21.04+[^1]   | [Ubuntu Packages]       | `apt install zoxide`                                                                                  |
   > | Void Linux          | [Void Linux Packages]   | `xbps-install -S zoxide`                                                                              |
   </details>

   <details>
   <summary>macOS</summary>

   > To install zoxide, use a package manager:
   >
   > | Repository      | Instructions                                                                                          |
      > | --------------- | ----------------------------------------------------------------------------------------------------- |
   > | **[crates.io]** | `cargo install zoxide --locked`                                                                       |
   > | **[Homebrew]**  | `brew install zoxide`                                                                                 |
   > | [asdf]          | `asdf plugin add zoxide https://github.com/nyrst/asdf-zoxide.git` <br /> `asdf install zoxide latest` |
   > | [conda-forge]   | `conda install -c conda-forge zoxide`                                                                 |
   > | [MacPorts]      | `port install zoxide`                                                                                 |
   >
   > Or, run this command in your terminal:
   >
   > ```sh
   > curl -sS https://raw.githubusercontent.com/ajeetdsouza/zoxide/main/install.sh | bash
   > ```
   </details>

   <details>
   <summary>Windows</summary>

   > The recommended way to install zoxide is via `winget`:
   >
   > ```sh
   > winget install zoxide
   > ```
   >
   > Or, you can use an alternative package manager:
   >
   > | Repository      | Instructions                          |
      > | --------------- | ------------------------------------- |
   > | **[crates.io]** | `cargo install zoxide --locked`       |
   > | [Chocolatey]    | `choco install zoxide`                |
   > | [conda-forge]   | `conda install -c conda-forge zoxide` |
   > | [Scoop]         | `scoop install zoxide`                |
   </details>

   <details>
   <summary>BSD</summary>

   > To install zoxide, use a package manager:
   >
   > | Distribution  | Repository      | Instructions                    |
      > | ------------- | --------------- | ------------------------------- |
   > | ***Any***     | **[crates.io]** | `cargo install zoxide --locked` |
   > | DragonFly BSD | [DPorts]        | `pkg install zoxide`            |
   > | FreeBSD       | [FreshPorts]    | `pkg install zoxide`            |
   > | NetBSD        | [pkgsrc]        | `pkgin install zoxide`          |
   </details>

   <details>
   <summary>Android</summary>

   > To install zoxide, use a package manager:
   >
   > | Repository | Instructions         |
      > | ---------- | -------------------- |
   > | [Termux]   | `pkg install zoxide` |
   </details>

2. **Setup zoxide on your shell**

   To start using zoxide, add it to your shell.

   <details>
   <summary>Bash</summary>

   > Add this to your configuration (usually `~/.bashrc`):
   >
   > ```sh
   > eval "$(zoxide init bash)"
   > ```
   </details>

   <details>
   <summary>Elvish</summary>

   > Add this to your configuration (usually `~/.elvish/rc.elv`):
   >
   > ```sh
   > eval (zoxide init elvish | slurp)
   > ```
   >
   > **Note**
   > zoxide only supports elvish v0.18.0 and above.
   </details>

   <details>
   <summary>Fish</summary>

   > Add this to your configuration (usually `~/.config/fish/config.fish`):
   >
   > ```fish
   > zoxide init fish | source
   > ```
   >
   > **Note**
   > zoxide only supports fish v3.4.0 and above.
   </details>

   <details>
   <summary>Nushell</summary>

   > Add this to your env file (find it by running `$nu.env-path` in Nushell):
   >
   > ```sh
   > zoxide init nushell | save -f ~/.zoxide.nu
   > ```
   >
   > Now, add this to the end of your config file (find it by running
   > `$nu.config-path` in Nushell):
   >
   > ```sh
   > source ~/.zoxide.nu
   > ```
   >
   > **Note**
   > zoxide only supports Nushell v0.73.0 and above.
   </details>

