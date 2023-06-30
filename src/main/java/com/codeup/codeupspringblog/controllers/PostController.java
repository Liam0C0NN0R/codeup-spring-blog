
package com.codeup.codeupspringblog.controllers;

        import models.Post;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;
        import java.util.List;

@Controller
public class PostController {

    // Class-level variable to store the posts
    private List<Post> posts = new ArrayList<>();

    // Initialize the posts in the constructor
    public PostController() {
        Post post1 = new Post();
        post1.setTitle("Carl");
        post1.setBody("\"How far away hydrogen atoms laws of physics cosmos galaxies Flatland ? Intelligent beings cosmic ocean courage of our questions citizens of distant epochs rich in heavy atoms Sea of Tranquility ? Another world as a patch of light invent the universe intelligent beings courage of our questions as a patch of light.Network of wormholes vanquish the impossible vastness is bearable only through love from which we spring two ghostly white figures in coveralls and helmets are softly dancing citizens of distant epochs and billions upon billions upon billions upon billions upon billions upon billions upon billions.\"");

        Post post2 = new Post();
        post2.setTitle("Monty");
        post2.setBody("[Thud][King Arthur music] [thud thud thud] [King Arthur music stops].Arthur, addressing a figure: \"Old woman!\" Dennis corrects him, \"Man.\" Arthur apologizes, \"Sorry. Old man! Whose castle is that?\" Dennis clarifies, \"I'm 37!\" Arthur is confused, \"What?\" Dennis insists, \"I'm 37, I'm not old!\" Arthur points out, \"Well, I can't just call you 'man'.\" Dennis suggests, \"Well, you could say 'Dennis'.\" Arthur responds, \"I didn't know you were called Dennis.\" Dennis accuses, \"You never bothered to find out, did you?\" Arthur tries to justify, \"I did say sorry about the old woman, but from behind you looked--\" Dennis interrupts, \"Well, I object. You're automatically treatin' me like an inferior!\" Arthur defends himself, \"Well, I am King.\" Dennis scoffs, \"Oh, King, eh, very nice. And how'd you get that, then? By exploitin' the workers, by hangin' on to our dated imperialist dogma, which perpetuates the economic and social differences in our society. If there's going to be any progress--\" His wife intervenes, \"Dennis, there's some lovely filth down here-- Oh, how'd you do.\" Arthur greets her, \"Hello, good woman. I am Arthur, King of the Britons. Whose castle is that?\" The woman asks, \"King of the who?\" Arthur clarifies, \"The Britons.\" The woman is confused, \"Who are the Britons?\" Arthur states, \"We are, we all are, and I am your King.\" The woman is surprised, \"I didn't know we had a King. I thought we were an autonomous collective.\" Dennis insists, \"You're fooling yourself. We're livin' in a dictatorship, a self-perpetuating autocracy, in which the working class--\" His wife interrupts, \"Oh, there you go, bringing class into it again--\" Dennis persists, \"But that's what it's all about! If only people would listen--\" Arthur pleads, \"Please, please, good people! I am in haste. Whose castle is that?\" The woman answers, \"No one lives there.\" Arthur queries, \"Then who is your lord?\" The woman states, \"We don't have a lord.\" Arthur is shocked, \"What?\" Dennis explains, \"I told you. We're an anarcho-syndicist commune. We take it in turn, to act as sort of an officer for the week--\" Arthur acknowledges, \"Yes, I see.\" Dennis continues, \"--but all the decisions of that officer have to be ratified at a special bi-weekly meeting--\" Arthur repeats, \"Yes, I see.\" Dennis doesn't stop, \"--by a simple majority, in the case of purely internal affairs--\" Arthur loses his patience, \"Be quiet.\" Dennis ignores him, \"--or by a two-thirds majority, in the case of--\" Arthur demands, \"Be quiet, I order you, be quiet!\" The woman sarcastically asks, \"Order, eh? Who's he think he is?\" Arthur states firmly, \"I am your King!\" The woman retorts, \"I didn't vote for you.\" Arthur corrects her, \"You don't vote for Kings.\" The woman queries, \"Well, how'd you become King, then?\" Arthur begins his tale, \"The Lady of the Lake,... [angels sing] ...her arm clad in the purest shimmering samite, held aloft Excalibur from the bosom of the water, signifying by divine providence that I, Arthur, was to carry Excalibur. [singing stops] THAT is why I'm your king!\" Dennis challenges him, \"Listen, strange women, lyin' in ponds, distributin' swords is no basis for a system of government. SUPREME executive power derives from a mandate of the masses, not from some farcical aquatic ceremony.\" Arthur commands, \"Shut up!\" Dennis mocks, \"You can't expect to wield supreme executive power, just 'cause some watery tart threw a sword at you!\" Arthur snaps, \"Shut up!\" Dennis continues his tirade, \"If I went around, sayin' I was an emperor, just 'cause some moistened dink had lobbed a scimitar at me, they'd put me away!\" Arthur loses it, \"Shut up! Will you shut up!\" and punches Dennis. Dennis points out, \"Oh, now we see the violence inherent in the system!\" Arthur hits him again, \"Shut up!\" Dennis calls for help, \"Come and see the violence inherent in the system! Help, help, I'm being repressed!\" Arthur dismisses him, \"Bloody peasant!\" Dennis exclaims, \"Oh, what a giveaway! Did you see that? Did you see him repressin' me? You saw it, didn't you?...\"");

        posts.add(post1);
        posts.add(post2);
    }

    @GetMapping("/posts/create")
    public String viewCreatePostForm() {
        return "View the form for creating a post";
    }

    @PostMapping("/posts/create")
    public String createPost() {
        return "Create a new post";
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable int id, Model model) {
        // Check if the id is valid
        if(id >= 0 && id < posts.size()) {
            // Get the post with the corresponding id
            Post post = posts.get(id);
            model.addAttribute("post", post);
        } else {
            // Handle the case where the id is not valid
            // You could return an error message or redirect to another page
        }

        return "posts/show";
    }
}
